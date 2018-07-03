package essential.traffic

sealed trait TrafficLight
{
    def next = this match
    {
        case Red => Green
        case Green => Yellow
        case Yellow => Red
    }
}
final case object Red extends TrafficLight
final case object Yellow extends TrafficLight
final case object Green extends TrafficLight
