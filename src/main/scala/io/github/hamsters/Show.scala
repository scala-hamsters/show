package io.github.hamsters

object Show {

  def show(p: Product): String = {
    p.productElementNames.zip(p.productIterator)
      .map {
        case (name, value: Seq[_]) => s"$name=[" + value.map{
          case v: Product => show(v)
          case v => v
        }.mkString(",") + "]"
        case (name, value: Product) => s"$name=${show(value)}"
        case (name, value) => s"$name=$value"
      }
      .mkString(p.productPrefix + "(", ",", ")")
  }

  implicit class ShowableProduct(p: Product) {
    def show: String = Show.show(p)
  }

}


