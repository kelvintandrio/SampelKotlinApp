package algo.project.kelvin.football.model

class RetroModel {

    var name: String? = null
    var country: String? = null
    var city: String? = null
    private var id: String? = null

    fun getid(): String? {
        return id
    }

    fun setid(id: String) {
        this.id = id
    }
}