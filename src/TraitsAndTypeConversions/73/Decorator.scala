/**
 * Trait 用于装饰对象
 */

//抽象类check 对申请的细节进行通用检查
abstract class Check {
  def check(): String = "Checked Application Details..."
}

/**
 * 对不同类型的检查，比如信贷，犯罪记录和雇佣记录，创建trait
 * 这些trait都继承自Check，首先这些trait只能混入继承自Check的类，其次在这些trait里可以使用Check的方法
 * super.trait
 * 在trait里，通过super调用方法会经历一个延迟绑定的过程，这个调用并不是对基类的调用，
 * 而是对其左边混入的trait的调用--如果这个trait已经是混入的最左trait，那么这个调用就会解析成
 * 混入这个trait的类的方法
 */
trait CreditCheck extends Check {
  override def check(): String = "Checked Credit..." + super.check()
}

trait EmploymentCheck extends Check {
  override def check(): String = "Checked Employment..." + super.check()
}

trait CriminalRecordCheck extends Check {
  override def check(): String = "Checked Criminal Records..." + super.check()
}

val apartmentApplication = new Check with CreditCheck with CriminalRecordCheck
println(apartmentApplication check)

val employmentApplication = new Check with CriminalRecordCheck with EmploymentCheck
println(employmentApplication check)


/**
 * 结果
 * Checked Criminal Records...Checked Credit...Checked Application Details...
   Checked Employment...Checked Criminal Records...Checked Application Details...
 */