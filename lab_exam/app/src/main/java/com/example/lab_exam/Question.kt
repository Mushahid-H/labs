data class Question(
    val questionText: String,
    val options: List<String>, // Assume the first option is always the correct one for simplicity
    var userAnswer: Int? = null ,
    val answerIndex: String

) {


}

