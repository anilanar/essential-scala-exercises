package essential

final case class Water(size: Int, source: WaterSource, carbonated: Boolean)

sealed trait WaterSource
final case object Well extends WaterSource
final case object Spring extends WaterSource
final case object Tap extends WaterSource
