package gr_test

class Child {
		Parent parent
		String name
    static belongsTo = Parent
		
    static constraints = {
       parent  nullable: true
    }
}
