import me.shadaj.scalapy.py
import me.shadaj.scalapy.py._

object CVXPYStackOverflow extends App {
  val np = py.module("numpy")
  val cp = py.module("cvxpy")
  val m = 67
  val n = 12
  val A = np.random.randn(m, n)
  val b = np.random.randn(m)
  val x = cp.Variable(n)
  println(py"${x.value}")
}
