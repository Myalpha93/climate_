package com.z.demo.service

import com.z.demo.model.Location

interface BasicCrud<T,ID>{
	fun findAll(): List<T>
	fun findById(id:ID): T?
	fun save(t:T): Boolean
	fun update(t: Location): Boolean
	fun deleteById(id:ID): Boolean
}