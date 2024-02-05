package devopenspace.temporal.carleasing.carleasing00

import io.temporal.activity.ActivityInterface

@ActivityInterface
interface CustomerJourneyActivity {
    fun isKnownCustomer(email:String): Boolean
    fun sendWelcomeMail(email: String)
    fun sendCheckupMail(email: String)
    fun sendCarInfoMail(email: String, carName: String)
    fun creditCheck(email: String): Boolean
    fun sendCreditCheckSuccessfulMail(email: String)
    fun leaseCar(car: String, email: String)
}
class CustomerJourneyActivityImpl: CustomerJourneyActivity {
    override fun isKnownCustomer(email: String): Boolean {
        println("Looking for existing customer with mail $email...")
        println("Customer not found")
        return false
    }

    override fun sendWelcomeMail(email: String) {
        println("Sending welcome mail to $email")
    }

    override fun sendCheckupMail(email: String) {
        println("Sending checkup mail to $email")
    }

    override fun sendCarInfoMail(email: String, carName: String) {
        println("Sending car info for $carName to $email")
    }

    override fun creditCheck(email: String): Boolean {
        println("Credit check successful")
        return true
    }

    override fun sendCreditCheckSuccessfulMail(email: String) {
        println("Send CreditCheck successful Mail to $email")
    }

    override fun leaseCar(car: String, email: String) {
        println("Car leased for $email")
    }
}
