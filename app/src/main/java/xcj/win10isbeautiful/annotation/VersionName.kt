package xcj.win10isbeautiful.annotation
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class VersionName(val name:String, val codeName:String) {

}