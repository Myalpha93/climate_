package com.z.climate.service

import com.z.climate.model.Location
import com.z.climate.model.Logs
import org.springframework.stereotype.Service

@Service
class LogsService: BasicCrud<Logs, String> {
	private val logs:MutableSet<Logs> = mutableSetOf()

	override fun findAll():List<Logs> = logs.toList()

	override fun update(t: Location): Boolean {
		TODO("Not yet implemented")
	}

	override fun deleteById(id: String): Boolean {
		TODO("Not yet implemented")
	}

	override fun save(t: Logs): Boolean = this.logs.add(t)

	override fun findById(id: String): Logs? {
		return this.logs.find { it.logID==id }
	}
}