case class Counter(val count: Int = 0)
{
    def dec: Counter = dec()
    def inc: Counter = inc()
    def dec(amount: Int = 1) = copy(count - amount)
    def inc(amount: Int = 1) = copy(count + amount)
}

Counter(10).inc.inc(10).dec(5).dec.count