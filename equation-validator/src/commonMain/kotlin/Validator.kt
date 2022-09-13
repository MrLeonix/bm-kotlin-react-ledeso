import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport()
@JsName("validateEquation")
fun validate(equationString: String): String {
    // TODO: Fix me!
    return if (equationString.isNotEmpty()) "FIXME" else "no input"
}