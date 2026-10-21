package KotlinFund_2

open class User(val email : String, val password: String ) {



    var firstname : String? = null
   private var lastname: String? = null
   private var age: Int?  = null

    fun getFirstName(): String?{
        return this.firstname
    }

    fun getLastName(): String?{
        return lastname
    }

    fun getAge(): Int?{
        return age
    }

    fun updateFirstname(firstName: String) {
        this.firstname = firstname
    }

    fun getUserEmail(): String{
        return this.email
    }

    fun updateLastname(lastName: String) {
      this.lastname = lastname
    }

    fun updateAge(age: Int) {
      this.age = age
    }

    override fun toString(): String {
        return getFirstName() + " "+  getLastName() + " "  +getUserEmail() + " "+ getAge()
    }
}