package com.github.verachadw.test

import com.github.verachadw.kreference.Kreference
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
The MIT License (MIT)

Copyright (c) 2015 Verachad Wongsawangtham

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 **/
class PropertiesTester : BaseTester() {

    val prefKey = "myPrefKey"
    val mockProperty = PropertyMetadataImpl(prefKey)

    @Test
    fun test_GetFromPropertyAsString() {
        val value = "Test Property"
        preference.edit {
            it.putString(prefKey, value)
        }

        val property = Kreference.asString(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(value, actual)
    }

    @Test
    fun test_SetToPropertyAsString() {
        val value = "Test Get Property"

        val property = Kreference.asString(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getString(prefKey, "")

        assertEquals(value, actual)
    }

    @Test
    fun test_GetFromPropertyAsInt() {
        val value = 100
        preference.edit {
            it.putInt(prefKey, value)
        }

        val property = Kreference.asInt(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(value, actual)
    }

    @Test
    fun test_SetToPropertyAsInt() {
        val value = 100

        val property = Kreference.asInt(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getInt(prefKey, 0)

        assertEquals(value, actual)
    }

    @Test
    fun test_GetFromPropertyAsFloat() {
        val value = 100f
        preference.edit {
            it.putFloat(prefKey, value)
        }

        val property = Kreference.asFloat(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(value, actual)
    }

    @Test
    fun test_SetToPropertyAsFloat() {
        val value = 100f

        val property = Kreference.asFloat(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getFloat(prefKey, 0f)

        assertEquals(value, actual)
    }

    @Test
    fun test_GetFromPropertyAsBoolean() {
        val value = true
        preference.edit {
            it.putBoolean(prefKey, value)
        }

        val property = Kreference.asBoolean(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(value, actual)
    }

    @Test
    fun test_SetToPropertyAsBoolean() {
        val value = true

        val property = Kreference.asBoolean(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getBoolean(prefKey, false)

        assertEquals(value, actual)
    }

    @Test
    fun test_GetFromPropertyAsLong() {
        val value = 100L
        preference.edit {
            it.putLong(prefKey, value)
        }

        val property = Kreference.asLong(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(value, actual)
    }

    @Test
    fun test_SetToPropertyAsLong() {
        val value = 100L

        val property = Kreference.asLong(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getLong(prefKey, 0L)

        assertEquals(value, actual)
    }

    @Test
    fun test_GetFromPropertyAsDateObject() {
        val value = 123456L
        preference.edit {
            it.putLong(prefKey, value)
        }

        val property = Kreference.asDate(context = mockContext)
        val actual = property.get(this, mockProperty)

        assertEquals(Date(value), actual)
    }

    @Test
    fun test_SetToPropertyAsDateObject() {
        val value = Date(123456L)

        val property = Kreference.asDate(context = mockContext)
        property.set(this, mockProperty, value)

        assert(preference.contains(prefKey))

        val actual = preference.getLong(prefKey, 0L)

        assertEquals(value.time, actual)
    }

}