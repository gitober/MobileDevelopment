class Student(val name: String, val age: Int) {
    val courses = mutableListOf<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        val totalCredits = courses.sumOf { it.credits }
        val weightedSum = courses.sumOf { it.grade * it.credits }
        return weightedSum / totalCredits
    }

    fun weightedAverage(year: Int): Double {
        val coursesForYear = courses.filter { it.yearCompleted == year }
        val totalCredits = coursesForYear.sumOf { it.credits }
        val weightedSum = coursesForYear.sumOf { it.grade * it.credits }
        return weightedSum / totalCredits
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val grades = courses.map { it.grade }
        return Pair(grades.minOrNull() ?: 0.0, grades.maxOrNull() ?: 0.0)
    }
}