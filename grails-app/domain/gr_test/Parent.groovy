package gr_test

class Parent {
		String name
		static hasMany=[children:Child]
		
    static constraints = {
        name nullable: true
    }
}
