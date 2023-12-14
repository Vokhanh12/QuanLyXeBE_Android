
import com.example.entities.EnityDriverDetail
import com.example.repositories.interfaces.IEntityDriverDetailRepository

open class BaseDriverDetailRepository<TEntity : EnityDriverDetail>(
    val driverIdProvider: (TEntity) -> String,
    val vehicleIdProvider: (TEntity) -> String) : IEntityDriverDetailRepository<TEntity> {

    var entities = mutableListOf<TEntity>()

    override suspend fun getAll(): List<TEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): TEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun replace(item: TEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insert(entity: TEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun find(predicate: (TEntity) -> Boolean): TEntity? {
        TODO("Not yet implemented")
    }


    override suspend fun findDriverNameByDriverDetailsId(driverDetailsId: String): String? {
        TODO("Not yet implemented")
    }
    override suspend fun findInRangeOfForeignKey(startKey: String, endKey: String) {
        TODO("Not yet implemented")
    }

    /*
    override suspend fun findInRangeOfForeignKey(startKey: String, endKey: String): List<TEntity> {
        return entities.filter { it.foreignKey in startKey..endKey }
    }

     */
}