import kotlin.math.sqrt

const val EPS = 0.0000001 // käytetään equals-vertaamiseen

class Complex(val real: Double, val imaginary: Double) {

    // Sekundaarinen konstruktori, joka hyväksyy kokonaislukuarvot
    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    // Ylikuormitetaan `+`-operaattori
    operator fun plus(other: Complex): Complex {
        return Complex(this.real + other.real, this.imaginary + other.imaginary)
    }

    // Ylikuormitetaan `-`-operaattori
    operator fun minus(other: Complex): Complex {
        return Complex(this.real - other.real, this.imaginary - other.imaginary)
    }

    // Ylikuormitetaan `*`-operaattori
    operator fun times(other: Complex): Complex {
        return Complex(
            this.real * other.real - this.imaginary * other.imaginary, // reaaliosa
            this.real * other.imaginary + this.imaginary * other.real  // imaginääriosa
        )
    }

    // Lasketaan itseisarvo (magnitudi)
    val abs: Double
        get() = sqrt(this.real * this.real + this.imaginary * this.imaginary)

    // Ylikirjoitetaan equals rakenteellista vertailua varten
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        return kotlin.math.abs(this.real - other.real) < EPS && // reaaliosan tarkistus
                kotlin.math.abs(this.imaginary - other.imaginary) < EPS // imaginääriosan tarkistus
    }

    // Ylikirjoitetaan hashCode
    override fun hashCode(): Int {
        return 31 * real.hashCode() + imaginary.hashCode()
    }

    // Ylikirjoitetaan toString helpompaa debuggausta varten
    override fun toString(): String {
        return "Complex(real=$real, imaginary=$imaginary)"
    }
}
