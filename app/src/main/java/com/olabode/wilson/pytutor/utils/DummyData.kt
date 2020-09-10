package com.olabode.wilson.pytutor.utils

import com.olabode.wilson.pytutor.models.tutorial.*
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
                                1 to Lesson(codeSnippet = null,
                                        imageUrl = "",
                                        type = LessonTypes.TEXT.ordinal,
                                        body = "Ubi est pius particula?Castus messors ducunt ad" +
                                                " frondator.Dexter eleates tandem gratias calcaria est."
                                ),
                                2 to Lesson(codeSnippet = null, imageUrl = "https://via.placeholder.com/150", type = LessonTypes.IMAGE.ordinal,
                                        body = "Barbatus resistentias ducunt ad rumor.Vae, amicitia!Parss sunt vortexs de varius cannabis.Velum absolute ducunt ad domesticus era.Fidelis, festus absolutios patienter resuscitabo de brevis, albus competition.Tumultumque de superbus nutrix, resuscitabo ventus!Demissio moris, tanquam bi-color imber.Sunt hilotaees imitari ferox, azureus hibridaes.Ubi est magnum mineralis?Clemens candidatus aegre resuscitabos triticum est.Terror de neuter era, imperium omnia!Festus, secundus magisters mechanice resuscitabo de nobilis, magnum tata.Fluctus ires, tanquam dexter particula.Heu, festus visus!Studere aegre ducunt ad primus classis.Pol, a bene tabes."
                                ),
                                3 to Lesson(codeSnippet = CodeSnippet(footer = "Complete Code", code = "for i in range 13:\n" +
                                        "\tprint(\"Hello python\")", header = "SampleUbi est talis medicina?Cur galatae trabem?A falsis, cursus teres pars.Capios crescere, tanquam mirabilis imber.Brevis cobaltums ducunt ad idoleum.Solitudo trabems, tanquam fidelis accentor.Luras sunt impositios de varius cobaltum.Festus, raptus plasmators acceleratrix imperium de magnum, audax valebat.Ecce.Cum xiphias favere, omnes stellaes transferre fortis, fidelis zetaes.Toruss sunt naviss de brevis fortis.Sunt adiuratores anhelare camerarius, fidelis lacteaes.Domesticus gemnas ducunt ad tata.Byssus, danista, et visus.Eheu.Cadunt satis ducunt ad domesticus bromium.Cur extum volare?Nuclear vexatum iacere primus valebat est."),
                                        imageUrl = "", type = LessonTypes.CODE.ordinal, body = ""),
                                4 to Lesson(codeSnippet = null,
                                        imageUrl = "",
                                        type = LessonTypes.TEXT.ordinal,
                                        body = "Ubi est pius particula?Castus messors ducunt ad" +
                                                " frondator.Dexter eleates tandem gratias calcaria est."
                                ),
                                5 to Lesson(codeSnippet = null,
                                        imageUrl = "",
                                        type = LessonTypes.TEXT.ordinal,
                                        body = "Ubi est pius particula?Castus messors ducunt ad" +
                                                " frondator.Dexter eleates tandem gratias calcaria est."
                                )
                        ),

                        type = LessonResponseType.LESSON.ordinal
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
                        ),
                        type = LessonResponseType.LESSON.ordinal

                ),

                LessonResponse(
                        3, lessons = null,
                        type = LessonResponseType.QUESTION.ordinal,
                        question = mapOf(
                                1 to Question(
                                        "hello ques"
                                )
                        )
                )
        )
    }
}