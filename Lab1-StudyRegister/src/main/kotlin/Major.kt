class Major(val name: String) {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        val averages = students.map { it.weightedAverage() }
        val min = averages.minOrNull() ?: 0.0
        val max = averages.maxOrNull() ?: 0.0
        val average = averages.average()
        return Triple(min, max, average)
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        val grades = students.flatMap { student ->
            student.courses.filter { it.name == courseName }.map { it.grade }
        }
        val min = grades.minOrNull() ?: 0.0
        val max = grades.maxOrNull() ?: 0.0
        val average = grades.average()
        return Triple(min, max, average)
    }
}