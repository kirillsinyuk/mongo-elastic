package com.kvsinyuk.elasticsearch.utils

import com.github.curiousoddman.rgxgen.RgxGen
import com.kvsinyuk.elasticsearch.domain.Buyer
import com.kvsinyuk.elasticsearch.domain.Contacts
import com.kvsinyuk.elasticsearch.domain.Deal
import com.kvsinyuk.elasticsearch.domain.Guarantor
import com.kvsinyuk.elasticsearch.domain.Name
import com.kvsinyuk.elasticsearch.domain.Seller
import java.time.LocalDate
import java.util.concurrent.ThreadLocalRandom

fun generateDeal(): Deal {
    return Deal()
        .apply {
            number = dealNumberPatternGenerator.generate()
            date = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(-hundredYears, hundredYears))
            sellers = createRandomSellers((0 until 10).random())
            buyers = createRandomBuyer((0 until 10).random())
            guarantors = createRandomGuarantors((0 until 3).random())
        }
}

fun createRandomSellers(sellersAmount: Int) =
    (0 until sellersAmount)
        .map {
            Seller()
                .apply {
                    name = createRandomName()
                    contacts = createRandomContacts()
                }
        }

fun createRandomBuyer(buyersAmount: Int) =
    (0 until buyersAmount)
        .map {
            Buyer()
                .apply {
                    name = createRandomName()
                    contacts = createRandomContacts()
                }
        }

fun createRandomGuarantors(guarantorsAmount: Int) =
    (0 until guarantorsAmount)
        .map {
            Guarantor()
                .apply {
                    name = createRandomName()
                    contacts = createRandomContacts()
                }
        }

fun createRandomName() =
    Name(
        firstName = nameList[(0..nameList.size).random()],
        lastName = nameList[(0..nameList.size).random()],
        middleName = nameList[(0..nameList.size).random()]
    )

fun createRandomContacts() =
    Contacts(
        email = emailPatternGenerator.generate(),
        phone = phonePatternGenerator.generate()
    )


private val dealNumberPatternGenerator = RgxGen("TEST-\\d{2}-\\d{5}")
private val emailPatternGenerator = RgxGen("[a-z]{5}@[a-z]{4}.com")
private val phonePatternGenerator = RgxGen("7\\d{10}")
private const val hundredYears = 100 * 365L
private val nameList = arrayOf(
"Ethan",
"Leo",
"Jackson",
"Mason",
"Ezra",
"John",
"Miles",
"Christopher",
"Nathan",
"Isaiah",
"Kai",
"Joshua",
"Eli",
"Wesley",
"Aaron",
"Ian",
"Christian",
"Ryan",
"Leonardo",
"Brooks",
"Axel",
"Walker",
"Jonathan",
"Robert",
"Luka",
"Connor",
"Alex",
"Milo",
"Enzo",
"Giovanni",
"Vincent",
"Diego",
"Luis",
"Archer",
)