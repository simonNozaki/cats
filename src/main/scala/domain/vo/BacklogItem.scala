package com.example
package domain.vo

import java.util.Date

/**
 * カンバン進捗オブジェクト。
 */
class BacklogItem private (
                            id: Id,
                            title: String,
                            description: String,
                            status: String,
                            createdAt: ISO8601Date,
                            updatedAt: ISO8601Date
                  ) {

  /**
   * アイテムを完了にする
   * @return
   */
  def makeDone(): BacklogItem = {
    // ステータス書き換える, 日付も更新
    return new BacklogItem(
      this.id,
      this.title,
      this.description,
      StatusDone.status,
      this.createdAt,
      ISO8601Date.fromDate(new Date())
    )
  }
}

/**
 * カンバン進捗コンパニオンオブジェクト
 */
object BacklogItem {
  def of(title: String, description: String, createdAt: ISO8601Date, updatedAt: ISO8601Date): BacklogItem = {
    return new BacklogItem(
      Id.of(),
      title,
      description,
      StatusTodo.status,
      createdAt,
      updatedAt
    )
  }
}

/**
 * バックログItemEnum
 */
sealed abstract class StatusEnum {
  val status: String
}

/**
 * バックログアイテムステータス: 未対応
 */
private case object StatusTodo extends StatusEnum {
  override val status: String = "todo"
}

/**
 * バックログアイテムステータス: 対応中
 */
private case object StatusWorkInProgress extends StatusEnum {
  override val status: String = "wip"
}

/**
 * バックログアイテムステータス: 完了
 */
private case object StatusDone extends StatusEnum {
  override val status: String = "done"
}