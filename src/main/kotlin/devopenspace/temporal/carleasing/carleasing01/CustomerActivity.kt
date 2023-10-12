package devopenspace.temporal.carleasing.carleasing01

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod

@ActivityInterface
interface CustomerActivity {
    @ActivityMethod
    fun isKnownCustomer(email:String): Boolean

    @ActivityMethod
    fun sendWelcomeMail(email: String)

    @ActivityMethod
    fun sendCarInfoMail(email: String, carName: String)
}
class CustomerActivityImpl: CustomerActivity {
    override fun isKnownCustomer(email: String): Boolean {
        println("Looking for existing customer with mail $email...")
        println("Customer not found")
        return false
    }

    override fun sendWelcomeMail(email: String) {
        println("Sending welcome mail to $email")
    }

    override fun sendCarInfoMail(email: String, carName: String) {
        println("Sending car info for $carName to $email")
    }
}
