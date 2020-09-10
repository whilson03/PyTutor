package com.olabode.wilson.pytutor.utils

import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/9/20.
 */
object DummyData {
    // Test Data
    fun getAllTopics(): List<TopicResponse> {
        return listOf(
                TopicResponse(
                        1,
                        "Variables",
                        "learn how to creates  variables",
                        3,
                        "1",
                        isLocked = false,
                        isCompleted = false
                ),
                TopicResponse(
                        1,
                        "Lists",
                        "learn how to creates  Lists",
                        7,
                        "2",
                        isLocked = false,
                        isCompleted = false
                ),
                TopicResponse(
                        1,
                        "Dictionary",
                        "learn how to creates  Dictionaries",
                        7,
                        "3",
                        isLocked = false,
                        isCompleted = false
                )
        )
    }


    fun getLessons(): List<LessonResponse> {
        return listOf(
                LessonResponse(
                        1,
                        mapOf(
                                1 to Lesson(codeSnippet = null, imageUrl = "", type = LessonTypes.TEXT.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                2 to Lesson(codeSnippet = null, imageUrl = "https://via.placeholder.com/150", type = LessonTypes.IMAGE.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                3 to Lesson(codeSnippet = CodeSnippet(footer = "Complete Code", code = "for i in range 13:\n" +
                                        "\tprint(\"Hello python\")", header = "SampleUbi est talis medicina?Cur galatae trabem?A falsis, cursus teres pars.Capios crescere, tanquam mirabilis imber.Brevis cobaltums ducunt ad idoleum.Solitudo trabems, tanquam fidelis accentor.Luras sunt impositios de varius cobaltum.Festus, raptus plasmators acceleratrix imperium de magnum, audax valebat.Ecce.Cum xiphias favere, omnes stellaes transferre fortis, fidelis zetaes.Toruss sunt naviss de brevis fortis.Sunt adiuratores anhelare camerarius, fidelis lacteaes.Domesticus gemnas ducunt ad tata.Byssus, danista, et visus.Eheu.Cadunt satis ducunt ad domesticus bromium.Cur extum volare?Nuclear vexatum iacere primus valebat est."),
                                        imageUrl = "", type = LessonTypes.CODE.ordinal, body = "")
                        )
                ),


                LessonResponse(
                        2,

                        mapOf(
                                1 to Lesson(codeSnippet = null, imageUrl = "", type = LessonTypes.TEXT.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                2 to Lesson(codeSnippet = null, imageUrl = "https://via.placeholder.com/150", type = LessonTypes.IMAGE.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                3 to Lesson(codeSnippet = CodeSnippet(footer = "Complete Code", code = "for i in range 13:\n" +
                                        "\tprint(\"Hello python\")", header = "SampleUbi est talis medicina?Cur galatae trabem?A falsis, cursus teres pars.Capios crescere, tanquam mirabilis imber.Brevis cobaltums ducunt ad idoleum.Solitudo trabems, tanquam fidelis accentor.Luras sunt impositios de varius cobaltum.Festus, raptus plasmators acceleratrix imperium de magnum, audax valebat.Ecce.Cum xiphias favere, omnes stellaes transferre fortis, fidelis zetaes.Toruss sunt naviss de brevis fortis.Sunt adiuratores anhelare camerarius, fidelis lacteaes.Domesticus gemnas ducunt ad tata.Byssus, danista, et visus.Eheu.Cadunt satis ducunt ad domesticus bromium.Cur extum volare?Nuclear vexatum iacere primus valebat est."),
                                        imageUrl = "", type = LessonTypes.CODE.ordinal, body = "")
                        )

                ),

                LessonResponse(
                        3,
                        mapOf(
                                1 to Lesson(codeSnippet = null, imageUrl = "", type = LessonTypes.TEXT.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                2 to Lesson(codeSnippet = null, imageUrl = "https://via.placeholder.com/150", type = LessonTypes.IMAGE.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                3 to Lesson(codeSnippet = CodeSnippet(footer = "Complete Code", code = "def get_total_courses(num):\n" +
                                        "    total_grade = 0\n" +
                                        "    total_unit = 0\n" +
                                        "    course_list = []\n" +
                                        "    if num <= 12:\n" +
                                        "        for i in range(1, num + 1):\n" +
                                        "            course = input(\"Enter Course\"+\" \"+str(i)+\" \"+\"Title: \")\n" +
                                        "            course_list.append(course)\n" +
                                        "            try:\n" +
                                        "                unit = int(input(\"Enter Unit of Course\" + str(i)+\": \"))\n" +
                                        "                total_unit += unit\n" +
                                        "            except ValueError:\n" +
                                        "                print(\"INVALID UNIT\")\n" +
                                        "                break\n" +
                                        "            score = int(input(\"Enter Course \"+\" \"+str(i)+\" \"+\"Score: \"))\n" +
                                        "            print(\"=\"*20)\n" +
                                        "            grd = get_grade(score)\n" +
                                        "            total_grade = total_grade + (grd * unit)\n" +
                                        "    return total_grade, total_unit", header = "SampleUbi est talis medicina?Cur galatae trabem?A falsis, cursus teres pars.Capios crescere, tanquam mirabilis imber.Brevis cobaltums ducunt ad idoleum.Solitudo trabems, tanquam fidelis accentor.Luras sunt impositios de varius cobaltum.Festus, raptus plasmators acceleratrix imperium de magnum, audax valebat.Ecce.Cum xiphias favere, omnes stellaes transferre fortis, fidelis zetaes.Toruss sunt naviss de brevis fortis.Sunt adiuratores anhelare camerarius, fidelis lacteaes.Domesticus gemnas ducunt ad tata.Byssus, danista, et visus.Eheu.Cadunt satis ducunt ad domesticus bromium.Cur extum volare?Nuclear vexatum iacere primus valebat est."),
                                        imageUrl = "", type = LessonTypes.CODE.ordinal, body = "")
                        )
                )
        )
    }
}