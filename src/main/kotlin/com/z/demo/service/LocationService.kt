package com.z.demo.service

import com.z.demo.controller.Requests
import com.z.demo.model.Location
import com.z.demo.utils.update
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.stereotype.Service

@Service
class LocationService: BasicCrud<Location, String> {
	private var locations: MutableSet<Location>  = mutableSetOf(
		Location(
			locationID="3871336",
			name="Santiago",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		),
		Location(
			locationID="2657896",
			name="Zürich",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		),
		Location(
			locationID="2193733",
			name="Auckland",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		),
		Location(
			locationID="2147714",
			name="Sydney",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		),
		Location(
			locationID="2643743",
			name="London",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		),
		Location(
			locationID="4064006",
			name="Georgiana",
			temp=0,
			wind_speed=0,
			wind_direction="",
			longitud=0.0,
			latitud=0.0
		)
	)

	override fun findAll():List<Location> {
		val location = locations.toList()
//        var valor = obtenerDatosPorLocation()

		for (i in location) {
			var id = i.locationID

			var jsonId: JSONObject = Requests.obtenerDatosPorLocation(id) as JSONObject
			var locat = locations.find { it.locationID==id }
			var locatNew = Location(
				locationID=id,
				name= jsonId.getString("city_name"),
				temp= jsonId.getInt("temp"),
				wind_speed=jsonId.getInt("wind_spd"),
				wind_direction=jsonId.getString("wind_cdir_full"),
				longitud=jsonId.getDouble("lon"),
				latitud=jsonId.getDouble("lat")
			)
			this.locations.remove(this.findById(id))
			this.locations.add(locatNew)

		}
		var entity = locations.toList()
		return entity
	}


	override fun deleteById(id: String): Boolean {
		return this.locations.remove(this.findById(id))
	}

	override fun update(t: Location): Boolean {
		println(t)
		println("iiiiiiiiiiiiiiii")
		return this.locations.update(t)
	}

	override fun save(t: Location): Boolean = this.locations.add(t)

	override fun findById(id: String): Location? {
		return this.locations.find { it.locationID===id }
	}
}