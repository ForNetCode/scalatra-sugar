package very.util.alert

import sttp.client3.HttpClientSyncBackend
import sttp.client3.logging.slf4j.Slf4jLoggingBackend
import sttp.client3.ziojson.{ *, given }
import sttp.client3.*
import very.util.config.WithConfig
import zio.json.*
import zio.json.ast.{ Json, JsonCursor }


trait WithAlert extends WithConfig {
  import very.util.config.getOptional
  object feiShuAlertBot
    extends FeiShuAlertBot(config.getString("alert.feishu.url"), config.getOptional[String]("alert.feishu.url.secret"))
}

//TODO: support send with secret
class FeiShuAlertBot(url: String, secret: Option[String] = None) extends Alert {

  private val client =
    Slf4jLoggingBackend(HttpClientSyncBackend())

  def send(text: String): Boolean = {
    val resp = basicRequest
      .post(uri"$url")
      .body(
        Json.Obj(
          "msg_type" -> Json.Str("text"),
          "content" -> Json.Obj("text" -> Json.Str(text)),
        )
      )
      .send(client)
    val body = resp.body.toJsonAST
    body.exists(j => j.get(JsonCursor.field("code").isNumber).exists(_.value == 0))
  }
}