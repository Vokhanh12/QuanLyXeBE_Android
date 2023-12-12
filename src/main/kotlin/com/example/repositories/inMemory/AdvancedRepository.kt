import com.example.entities.EnityDriverDetail
import com.example.entities.Entity
import com.example.entities.Vehicle
import com.example.repositories.interfaces.IEntityDetailRepository

open class AdvancedRepository<TEntity : EnityDriverDetail>(
    private val driverIdProvider: (TEntity) -> String,
    private val vehicleIdProvider: (TEntity) -> String
) : IEntityDetailRepository<TEntity> {

    private var entities = mutableListOf<TEntity>()

    override suspend fun getAll(): List<TEntity> {
        return entities
    }

    override suspend fun insert(entity: Entity) {

    }

    override suspend fun delete(id: String) {

    }

    override suspend fun replace(item: TEntity) {

    }

    override suspend fun findVehicleNameByDriverDetailsId(driverDetailsId: String): String? {
        val driverDetails = entities.find { driverIdProvider(it) == driverDetailsId }
        return driverDetails?.let {
            val vehicleId = vehicleIdProvider(it)
            val vehicle = entities.find { vehicleIdProvider(it) == vehicleId }
            (vehicle as? Vehicle)?.name
        }
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