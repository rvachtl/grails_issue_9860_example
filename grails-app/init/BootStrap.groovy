import gr_test.Parent
import gr_test.Child

class BootStrap {

    def init = { servletContext ->
    
     println "bootstrap running"
        // Check whether the test data already exists.
        if (!Parent.count()) {            
            def p=new Parent(name:'p_C')
            def c=new Child(name:'baby1')
            c.parent=p
            p.save(flush: true,failOnError:true)
            c.save(flush: true,failOnError:true)    

            p=new Parent(name:'p_B')
            c=new Child(name:'baby2')
            c.parent=p
            p.save(flush: true,failOnError:true)
            c.save(flush: true,failOnError:true)    

            p=new Parent(name:'p_A')
            c=new Child(name:'baby3')
            c.parent=p
            p.save(flush: true,failOnError:true)
            c.save(flush: true,failOnError:true)    

            c=new Child(name:'baby_with_parent-name_null')
            p=new Parent(name:null)
            p.save(flush: true,failOnError:true)
            c.parent=p 
            c.save(flush: true,failOnError:true)    
            
            println "init finished."
        }
    }
    def destroy = {
    }
}
