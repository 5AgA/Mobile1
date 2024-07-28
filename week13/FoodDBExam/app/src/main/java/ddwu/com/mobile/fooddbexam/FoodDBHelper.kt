package ddwu.com.mobile.fooddbexam

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class FoodDBHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    val TAG = "FoodDBHelper"

    // DB 및 테이블, 컬럼명 등을 보관
    companion object {
        const val DB_NAME = "food_db"
        const val TABLE_NAME = "food_table"
        const val COL_FOOD = "food"
        const val COL_COUNTRY = "country"
    }

    // ** 최초로 readableDatabase 또는 writeableDatabase 사용 시 호출 (한 번만 실행)
    // DB의 테이블 생성 및 샘플 데이터 추가
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE ${TABLE_NAME} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${COL_FOOD} TEXT, ${COL_COUNTRY} TEXT )"
        Log.d(TAG, CREATE_TABLE)
        db?.execSQL(CREATE_TABLE)
    }

    // 새로운 버전의 DB를 사용할 필요가 있을 때 사용
    override fun onUpgrade(db: SQLiteDatabase?, oldVer: Int, newVer: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }
}