import androidx.room.Room
import com.elfatah.pokeapp.BuildConfig
import com.elfatah.pokeapp.data.local.PokeDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            PokeDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).build()
    }

    single { get<PokeDatabase>().pokemonDao() }
}