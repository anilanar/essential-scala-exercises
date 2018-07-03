package essential

case class Counter(val count: Int = 0)
{
    def dec: Counter = dec()
    def inc: Counter = inc()
    def dec(amount: Int = 1) = copy(count - amount)
    def inc(amount: Int = 1) = copy(count + amount)
}
