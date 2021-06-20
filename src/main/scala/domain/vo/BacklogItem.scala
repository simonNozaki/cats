package com.example
package domain.vo

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
    // ステータス書き換える
    return this
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
 * バックログアイテムステータス: Todo
 */
private case object StatusTodo extends StatusEnum {
  override val status: String = "todo"
}

/**
 * バックログアイテムステータス: wip
 */
private case object StatusWorkInProgress extends StatusEnum {
  override val status: String = "wip"
}

/**
 * バックログアイテムステータス: done
 */
private case object StatusDone extends StatusEnum {
  override val status: String = "done"
}