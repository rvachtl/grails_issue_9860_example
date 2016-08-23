package gr_test

class HomeController {
  
  def index() { 
    
    def q1=Child.where{
        (name!=null)
    }			

    def q2=Child.where{
        (parent.name!=null)
    }
    
    // following example with alias works though:
    def q_works=Child.where{
        (parent.name!=null)
        createAlias('parent','_p')
    }
    
    def printResult={zz->
      println "size:${zz.size()} class: ${zz.getClass()} total: ${zz.getTotalCount()}"
      zz.each{
        println "${it.name}:${it?.parent.name}"				
      }
    }

    def result

    result=q1.list([max:3,sort:'parent.name'])      
    printResult(result)

    result=q2.list([max:3])      
    printResult(result)

    //FAILS in groovy 3.1.10:
    result=q2.list([max:3,sort:'parent.name'])      
    printResult(result)
    
    result=q_works.list([max:3,sort:'_p.name'])      
    printResult(result)
    
    
    render 'OK'
  }
  
  
  def addData(){
    def p=new Parent(name:'p1')
    def c=new Child(name:'dite')
    c.parent=p
    
    if (!p.save(flush: true)) {
      p.errors.each {
          println it
      }
    }
    if (!c.save()					){
      
      c.errors.each{
        println it
      }
    }
    
    render "done: ${p} ${c}"			
  }
}
