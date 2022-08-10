package edu.uchicago.skgrogg.movies.common



import com.google.gson.Gson
import edu.uchicago.skgrogg.movies.models.MoviesResponse
import edu.uchicago.skgrogg.movies.models.Result

object Constants {
    var id = "ID"
    var item = "ITEM"
    var favMode = "FAVORITE_MODE"
    var action = "ACTION"
    val movieURL = "https://api.themoviedb.org/"
    val apiKey = "51a9be0f300c3e328f4ab8b660df95aa"
    val sortBy = "popularity.desc"

    val lightsailURL = "https://quarkus-and-mongo.ssc846f0mfhpe.us-east-1.cs.amazonlightsail.com/movies"
    val emailURL = "https://7fof14yl3j.execute-api.us-east-1.amazonaws.com/Prod/mail"

    val fakeMovie: Result
    val fakeMovieResponse: MoviesResponse

    //use init to parse the raw response-body
    init {


        val gsonMovies = Gson()
        val hardCodedMovies = """
            {
           "page":1,
           "results":[
              {
                 "adult":false,
                 "backdrop_path":"/t9K8ycUBCplWiICDOKRNRYcEH9e.jpg",
                 "genre_ids":[
                    16,
                    28,
                    14
                 ],
                 "id":810693,
                 "original_language":"ja",
                 "original_title":"劇場版 呪術廻戦 0",
                 "overview":"Yuta Okkotsu is a nervous high school student who is suffering from a serious problem—his childhood friend Rika has turned into a curse and won't leave him alone. Since Rika is no ordinary curse, his plight is noticed by Satoru Gojo, a teacher at Jujutsu High, a school where fledgling exorcists learn how to combat curses. Gojo convinces Yuta to enroll, but can he learn enough in time to confront the curse that haunts him?",
                 "popularity":1712.85,
                 "poster_path":"/3pTwMUEavTzVOh6yLN0aEwR7uSy.jpg",
                 "release_date":"2021-12-24",
                 "title":"Jujutsu Kaisen 0",
                 "video":false,
                 "vote_average":7.9,
                 "vote_count":223
              },
              {
                 "adult":false,
                 "backdrop_path":"/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg",
                 "genre_ids":[
                    28,
                    12,
                    878
                 ],
                 "id":634649,
                 "original_language":"en",
                 "original_title":"Spider-Man: No Way Home",
                 "overview":"Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                 "popularity":1623.751,
                 "poster_path":"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                 "release_date":"2021-12-15",
                 "title":"Spider-Man: No Way Home",
                 "video":false,
                 "vote_average":8.1,
                 "vote_count":14219
              },
              {
                 "adult":false,
                 "backdrop_path":"/2kvl6lcgoyAaf8cSRkzxE611u6T.jpg",
                 "genre_ids":[
                    16,
                    28,
                    14,
                    878
                 ],
                 "id":761898,
                 "original_language":"ja",
                 "original_title":"劇場版 ソードアート・オンライン プログレッシブ 星なき夜のアリア",
                 "overview":"One month after Kayaba Akihiko's game of death began, the death toll continues to rise, two thousand players having already lost their lives to the ultra-difficult VRMMO world of Sword Art Online. On the day of the strategy meeting to plan out the first-floor boss battle, Kirito, a solo player who vows to fight alone to get stronger, runs into a rare, high-level female player. She gracefully dispatches powerful monsters with a single rapier that flashes like a shooting star in the night...",
                 "popularity":818.911,
                 "poster_path":"/yD9RhgIVydQNBK7OLEbCWYcWMUd.jpg",
                 "release_date":"2021-10-30",
                 "title":"Sword Art Online the Movie -Progressive- Aria of a Starless Night",
                 "video":false,
                 "vote_average":8.5,
                 "vote_count":51
              },
              {
                 "adult":false,
                 "backdrop_path":"/3G1Q5xF40HkUBJXxt2DQgQzKTp5.jpg",
                 "genre_ids":[
                    16,
                    35,
                    10751,
                    14
                 ],
                 "id":568124,
                 "original_language":"en",
                 "original_title":"Encanto",
                 "overview":"The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                 "popularity":816.458,
                 "poster_path":"/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                 "release_date":"2021-11-24",
                 "title":"Encanto",
                 "video":false,
                 "vote_average":7.7,
                 "vote_count":6957
              },
              {
                 "adult":false,
                 "backdrop_path":"/l83VzRBverTuAFyh9N9dMYsPr4m.jpg",
                 "genre_ids":[
                    80,
                    28
                 ],
                 "id":893297,
                 "original_language":"en",
                 "original_title":"American Sicario",
                 "overview":"The story of the rise and fall of the first American-born drug lord in Mexico, this tale of power, money, greed and betrayal amongst rival members of the drug cartels finds American gangster Erik Vasquez scheming to become the top dog in the Mexican underworld, only to find himself making enemies out of both the powerful cartels and his own allies.",
                 "popularity":775.356,
                 "poster_path":"/nQRPSUmHGLrFRPK6v3BI1frAM1O.jpg",
                 "release_date":"2021-12-10",
                 "title":"American Sicario",
                 "video":false,
                 "vote_average":6,
                 "vote_count":59
              },
              {
                 "adult":false,
                 "backdrop_path":"/qp8qKiP7Q7zK4z3LItwWMHfV9kJ.jpg",
                 "genre_ids":[
                    53
                 ],
                 "id":764835,
                 "original_language":"en",
                 "original_title":"The Desperate Hour",
                 "overview":"A woman desperately races to save her child after police place her hometown on lockdown due to an active shooter incident.",
                 "popularity":635.34,
                 "poster_path":"/u6Pg9eTklhg6Aa7kXaxrfdE1Chi.jpg",
                 "release_date":"2021-09-12",
                 "title":"The Desperate Hour",
                 "video":false,
                 "vote_average":6.2,
                 "vote_count":178
              },
              {
                 "adult":false,
                 "backdrop_path":"/cugmVwK0N4aAcLibelKN5jWDXSx.jpg",
                 "genre_ids":[
                    16,
                    28,
                    12,
                    878
                 ],
                 "id":768744,
                 "original_language":"ja",
                 "original_title":"僕のヒーローアカデミア THE MOVIE ワールド ヒーローズ ミッション",
                 "overview":"A mysterious group called Humarize strongly believes in the Quirk Singularity Doomsday theory which states that when quirks get mixed further in with future generations, that power will bring forth the end of humanity. In order to save everyone, the Pro-Heroes around the world ask UA Academy heroes-in-training to assist them and form a world-classic selected hero team. It is up to the heroes to save the world and the future of heroes in what is the most dangerous crisis to take place yet in My Hero Academia.",
                 "popularity":605.914,
                 "poster_path":"/AsTlA7dj2ySGY1pzGSD0MoHFhEF.jpg",
                 "release_date":"2021-08-06",
                 "title":"My Hero Academia: World Heroes' Mission",
                 "video":false,
                 "vote_average":7.6,
                 "vote_count":221
              },
              {
                 "adult":false,
                 "backdrop_path":"/o76ZDm8PS9791XiuieNB93UZcRV.jpg",
                 "genre_ids":[
                    27,
                    28,
                    878
                 ],
                 "id":460458,
                 "original_language":"en",
                 "original_title":"Resident Evil: Welcome to Raccoon City",
                 "overview":"Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                 "popularity":554.654,
                 "poster_path":"/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
                 "release_date":"2021-11-24",
                 "title":"Resident Evil: Welcome to Raccoon City",
                 "video":false,
                 "vote_average":6.1,
                 "vote_count":1714
              },
              {
                 "adult":false,
                 "backdrop_path":"/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                 "genre_ids":[
                    878,
                    28,
                    12
                 ],
                 "id":580489,
                 "original_language":"en",
                 "original_title":"Venom: Let There Be Carnage",
                 "overview":"After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                 "popularity":527.932,
                 "poster_path":"/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                 "release_date":"2021-09-30",
                 "title":"Venom: Let There Be Carnage",
                 "video":false,
                 "vote_average":7,
                 "vote_count":7667
              },
              {
                 "adult":false,
                 "backdrop_path":"/6mJrgL7Mi13XjJeGYJFlD6UEVQw.jpg",
                 "genre_ids":[
                    16,
                    35,
                    10751,
                    10402
                 ],
                 "id":438695,
                 "original_language":"en",
                 "original_title":"Sing 2",
                 "overview":"Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                 "popularity":497.091,
                 "poster_path":"/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                 "release_date":"2021-12-01",
                 "title":"Sing 2",
                 "video":false,
                 "vote_average":8.1,
                 "vote_count":2966
              },
              {
                 "adult":false,
                 "backdrop_path":"/zl659TsITC6CEeNApdxZsn5ycuf.jpg",
                 "genre_ids":[
                    16,
                    35,
                    12,
                    10751
                 ],
                 "id":459151,
                 "original_language":"en",
                 "original_title":"The Boss Baby: Family Business",
                 "overview":"The Templeton brothers — Tim and his Boss Baby little bro Ted — have become adults and drifted away from each other. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again … and inspire a new family business.",
                 "popularity":476.272,
                 "poster_path":"/kv2Qk9MKFFQo4WQPaYta599HkJP.jpg",
                 "release_date":"2021-07-01",
                 "title":"The Boss Baby: Family Business",
                 "video":false,
                 "vote_average":7.5,
                 "vote_count":1994
              },
              {
                 "adult":false,
                 "backdrop_path":"/vkjsoMF86dJIv6Sgtd4CcuR8kzh.jpg",
                 "genre_ids":[
                    16,
                    14
                 ],
                 "id":843241,
                 "original_language":"ja",
                 "original_title":"劇場版 七つの大罪 光に呪われし者たち",
                 "overview":"With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
                 "popularity":470.787,
                 "poster_path":"/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg",
                 "release_date":"2021-07-02",
                 "title":"The Seven Deadly Sins: Cursed by Light",
                 "video":false,
                 "vote_average":7.9,
                 "vote_count":362
              },
              {
                 "adult":false,
                 "backdrop_path":"/ubty43lOcYeeWMnWxszdNsrzf1z.jpg",
                 "genre_ids":[
                    16,
                    12,
                    10751,
                    14
                 ],
                 "id":809717,
                 "original_language":"de",
                 "original_title":"Peterchens Mondfahrt",
                 "overview":"When Peter sets out on a magical journey to rescue his little sister Anne, he needs to travel to mysterious territory: the Moon! Anne was kidnapped by the evil Moon Man when she tried to help the beetle Mr. Zoomzeman in search for his wife. On his fantastic adventure, Peter lands on the Star Meadow where he meets the sleepy Mr. Sandman. He knows, only at the Night Fairy’s dinner in the castle in the clouds, they can find out where Anne is – but there aren’t enough seats for everyone. So they join the wild race along the Milky Way against the five Spirits of Nature: Storm Giant, Lightning Witch, Henry Hail, Rainy Robin and Mother Frost…",
                 "popularity":457.356,
                 "poster_path":"/bkp1oHMvDwDTlbRhCcqAK0A7JNd.jpg",
                 "release_date":"2021-06-24",
                 "title":"Moonbound",
                 "video":false,
                 "vote_average":6,
                 "vote_count":40
              },
              {
                 "adult":false,
                 "backdrop_path":"/eHRtXoPDAUUX7LWXvQfFAK2nFkG.jpg",
                 "genre_ids":[
                    27
                 ],
                 "id":708471,
                 "original_language":"es",
                 "original_title":"El último zombi",
                 "overview":"",
                 "popularity":439.685,
                 "poster_path":"/rSxEMxgLnC1KZAYH6pEksPsLyzR.jpg",
                 "release_date":"2021-12-02",
                 "title":"The Last Zombie",
                 "video":false,
                 "vote_average":6,
                 "vote_count":2
              },
              {
                 "adult":false,
                 "backdrop_path":"/zxWAv1A34kdYslBi4ekMDtgIGUt.jpg",
                 "genre_ids":[
                    28,
                    12,
                    14
                 ],
                 "id":566525,
                 "original_language":"en",
                 "original_title":"Shang-Chi and the Legend of the Ten Rings",
                 "overview":"Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                 "popularity":419.632,
                 "poster_path":"/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                 "release_date":"2021-09-01",
                 "title":"Shang-Chi and the Legend of the Ten Rings",
                 "video":false,
                 "vote_average":7.7,
                 "vote_count":6828
              },
              {
                 "adult":false,
                 "backdrop_path":"/c6H7Z4u73ir3cIoCteuhJh7UCAR.jpg",
                 "genre_ids":[
                    878,
                    28,
                    12
                 ],
                 "id":524434,
                 "original_language":"en",
                 "original_title":"Eternals",
                 "overview":"The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                 "popularity":381.307,
                 "poster_path":"/lFByFSLV5WDJEv3KabbdAF959F2.jpg",
                 "release_date":"2021-11-03",
                 "title":"Eternals",
                 "video":false,
                 "vote_average":7.1,
                 "vote_count":5928
              },
              {
                 "adult":false,
                 "backdrop_path":null,
                 "genre_ids":[
                    14,
                    18
                 ],
                 "id":770509,
                 "original_language":"es",
                 "original_title":"Las noches son de los monstruos",
                 "overview":"Sol, a 17-year-old teenager, moves with her mother to the Gonzalo's home, the actual mother's boyfriend. In this town, where from the beginning Sol only finds hostility, she must face bullying from her schoolmates and Gonzalo's harassment. While wandering the streets trying to find a way out, Sol meet a mysterious and magical female dog with whom she establish a symbiotic relationship. It be this dog, the one that violently and surprisingly, always appear to defend Sol until the last consequences.",
                 "popularity":366.537,
                 "poster_path":"/cYNfI1WHxMm0JhCXEX9qUUOv8C3.jpg",
                 "release_date":"2021-10-09",
                 "title":"The Nights Belong to Monsters",
                 "video":false,
                 "vote_average":6,
                 "vote_count":2
              },
              {
                 "adult":false,
                 "backdrop_path":"/zplzc6jxO3SK7Pa4yxVoRY5VflT.jpg",
                 "genre_ids":[
                    14,
                    35,
                    12
                 ],
                 "id":425909,
                 "original_language":"en",
                 "original_title":"Ghostbusters: Afterlife",
                 "overview":"When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                 "popularity":362.03,
                 "poster_path":"/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
                 "release_date":"2021-11-11",
                 "title":"Ghostbusters: Afterlife",
                 "video":false,
                 "vote_average":7.6,
                 "vote_count":2974
              },
              {
                 "adult":false,
                 "backdrop_path":"/lV3UFPPxDIPelh46G9oySXN9Mcz.jpg",
                 "genre_ids":[
                    10749,
                    18
                 ],
                 "id":744275,
                 "original_language":"en",
                 "original_title":"After We Fell",
                 "overview":"Just as Tessa's life begins to become unglued, nothing is what she thought it would be. Not her friends nor her family. The only person that she should be able to rely on is Hardin, who is furious when he discovers the massive secret that she's been keeping. Before Tessa makes the biggest decision of her life, everything changes because of revelations about her family.",
                 "popularity":361.62,
                 "poster_path":"/dU4HfnTEJDf9KvxGS9hgO7BVeju.jpg",
                 "release_date":"2021-09-01",
                 "title":"After We Fell",
                 "video":false,
                 "vote_average":7.1,
                 "vote_count":1782
              },
              {
                 "adult":false,
                 "backdrop_path":"/svVppV4UOQw1fVi1Dt6z7n2UlyG.jpg",
                 "genre_ids":[
                    35
                 ],
                 "id":920143,
                 "original_language":"es",
                 "original_title":"El paseo 6",
                 "overview":"The last year High School excursion is the walk where anything can happen, but the last year High School excursion with the parents, that is the last straw. And since Álvaro Castaño knows that security is better than the police, he decides to travel with his family to watch over his daughter Sarita, however, his mother-in-law, Raquel, is not willing to allow it and also embarks in the plan . On the paradisiacal beaches of San Andrés, Álvaro Castaño will become Sara's nightmare and the sensation for the excursion, while his sexy mother-in-law of him will be the one to steal the show. El Paseo 6, the last yeat High School excursion, because the luck of the grandmother, the High School girls wish it.",
                 "popularity":360.378,
                 "poster_path":"/5vSFW0rxMDZg8j5cr0JICBDSrGM.jpg",
                 "release_date":"2021-12-25",
                 "title":"The Trip 6",
                 "video":false,
                 "vote_average":7.2,
                 "vote_count":54
              }
           ],
           "total_pages":1488,
           "total_results":29756
        }
        """

        fakeMovieResponse =
            gsonMovies.fromJson<MoviesResponse>(hardCodedMovies, MoviesResponse::class.java)
        fakeMovie = fakeMovieResponse.results[0]
    }


}