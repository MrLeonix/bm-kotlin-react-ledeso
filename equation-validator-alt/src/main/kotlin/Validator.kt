fun validate(equationString: String): String {
    val regex = Regex("^(\\d+)\\s*\\+\\s*(\\d+)\\s*=\\s*(\\d+)$")

    if (!equationString.matches(regex)) {
        return "syntax error"
    }

    regex.matchEntire(equationString)!!.groupValues.drop(1).map { it.toInt() }.let { groupValues ->
        val equationFirst = groupValues[0]
        val equationSecond = groupValues[1]
        val equationResult = groupValues[2]

        return if (equationFirst + equationSecond == equationResult) "valid"
        else "invalid"
    }
}
