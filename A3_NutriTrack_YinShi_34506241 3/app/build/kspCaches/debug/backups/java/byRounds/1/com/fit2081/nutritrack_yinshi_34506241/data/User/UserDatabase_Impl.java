package com.fit2081.nutritrack_yinshi_34506241.data.User;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponseDao;
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponseDao_Impl;
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireDao;
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDatabase_Impl extends UserDatabase {
  private volatile UserDao _userDao;

  private volatile QuestionnaireDao _questionnaireDao;

  private volatile AIResponseDao _aIResponseDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `sex` TEXT NOT NULL, `HEIFAtotalscore` REAL NOT NULL, `DiscretionaryHEIFAscore` REAL NOT NULL, `Discretionaryservesize` REAL NOT NULL, `VegetablesHEIFAscore` REAL NOT NULL, `Vegetableswithlegumesallocatedservesize` REAL NOT NULL, `LegumesallocatedVegetables` REAL NOT NULL, `Vegetablesvariationsscore` REAL NOT NULL, `VegetablesCruciferous` REAL NOT NULL, `VegetablesTuberandbulb` REAL NOT NULL, `VegetablesOther` REAL NOT NULL, `Legumes` REAL NOT NULL, `VegetablesGreen` REAL NOT NULL, `VegetablesRedandorange` REAL NOT NULL, `FruitHEIFAscore` REAL NOT NULL, `Fruitserversize` REAL NOT NULL, `Fruitvariationsscore` REAL NOT NULL, `FruitPome` REAL NOT NULL, `FruitTropicalandsubtropical` REAL NOT NULL, `FruitBerry` REAL NOT NULL, `FruitStone` REAL NOT NULL, `FruitCitrus` REAL NOT NULL, `FruitOther` REAL NOT NULL, `GrainsandcerealsHEIFAscore` REAL NOT NULL, `Grainsandcerealsservesize` REAL NOT NULL, `GrainsandcerealsNonwholegrains` REAL NOT NULL, `WholegrainsHEIFAscore` REAL NOT NULL, `Wholegrainsservesize` REAL NOT NULL, `MeatandalternativesHEIFAscore` REAL NOT NULL, `Meatandalternativeswithlegumesallocatedservesize` REAL NOT NULL, `LegumesallocatedMeatandalternatives` REAL NOT NULL, `DairyandalternativesHEIFAscore` REAL NOT NULL, `Dairyandalternativesservesize` REAL NOT NULL, `SodiumHEIFAscore` REAL NOT NULL, `Sodiummgmilligrams` REAL NOT NULL, `AlcoholHEIFAscore` REAL NOT NULL, `Alcoholstandarddrinks` REAL NOT NULL, `WaterHEIFAscore` REAL NOT NULL, `Water` REAL NOT NULL, `WaterTotalmL` REAL NOT NULL, `BeverageTotalmL` REAL NOT NULL, `SugarHEIFAscore` REAL NOT NULL, `Sugar` REAL NOT NULL, `SaturatedFatHEIFAscore` REAL NOT NULL, `SaturatedFat` REAL NOT NULL, `UnsaturatedFatHEIFAscore` REAL NOT NULL, `UnsaturatedFatservesize` REAL NOT NULL, `questionnaire` INTEGER NOT NULL, `password` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `food_questionnaire` (`questionnaireId` TEXT NOT NULL, `firstPartResult` TEXT NOT NULL, `thirdPartResult` TEXT NOT NULL, `fourthPartResult` TEXT NOT NULL, PRIMARY KEY(`questionnaireId`), FOREIGN KEY(`questionnaireId`) REFERENCES `user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ai_response` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `promptTips` TEXT NOT NULL, `promptFeedback` TEXT NOT NULL, `tip` TEXT NOT NULL, `feedback` TEXT NOT NULL, `dateTime` TEXT NOT NULL, FOREIGN KEY(`userId`) REFERENCES `user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_ai_response_id` ON `ai_response` (`id`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5a37afce95a6321a75047e6681c6acb1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `user`");
        db.execSQL("DROP TABLE IF EXISTS `food_questionnaire`");
        db.execSQL("DROP TABLE IF EXISTS `ai_response`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(51);
        _columnsUser.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("sex", new TableInfo.Column("sex", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("HEIFAtotalscore", new TableInfo.Column("HEIFAtotalscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("DiscretionaryHEIFAscore", new TableInfo.Column("DiscretionaryHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Discretionaryservesize", new TableInfo.Column("Discretionaryservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesHEIFAscore", new TableInfo.Column("VegetablesHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Vegetableswithlegumesallocatedservesize", new TableInfo.Column("Vegetableswithlegumesallocatedservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("LegumesallocatedVegetables", new TableInfo.Column("LegumesallocatedVegetables", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Vegetablesvariationsscore", new TableInfo.Column("Vegetablesvariationsscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesCruciferous", new TableInfo.Column("VegetablesCruciferous", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesTuberandbulb", new TableInfo.Column("VegetablesTuberandbulb", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesOther", new TableInfo.Column("VegetablesOther", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Legumes", new TableInfo.Column("Legumes", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesGreen", new TableInfo.Column("VegetablesGreen", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("VegetablesRedandorange", new TableInfo.Column("VegetablesRedandorange", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitHEIFAscore", new TableInfo.Column("FruitHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Fruitserversize", new TableInfo.Column("Fruitserversize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Fruitvariationsscore", new TableInfo.Column("Fruitvariationsscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitPome", new TableInfo.Column("FruitPome", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitTropicalandsubtropical", new TableInfo.Column("FruitTropicalandsubtropical", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitBerry", new TableInfo.Column("FruitBerry", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitStone", new TableInfo.Column("FruitStone", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitCitrus", new TableInfo.Column("FruitCitrus", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("FruitOther", new TableInfo.Column("FruitOther", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("GrainsandcerealsHEIFAscore", new TableInfo.Column("GrainsandcerealsHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Grainsandcerealsservesize", new TableInfo.Column("Grainsandcerealsservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("GrainsandcerealsNonwholegrains", new TableInfo.Column("GrainsandcerealsNonwholegrains", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("WholegrainsHEIFAscore", new TableInfo.Column("WholegrainsHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Wholegrainsservesize", new TableInfo.Column("Wholegrainsservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("MeatandalternativesHEIFAscore", new TableInfo.Column("MeatandalternativesHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Meatandalternativeswithlegumesallocatedservesize", new TableInfo.Column("Meatandalternativeswithlegumesallocatedservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("LegumesallocatedMeatandalternatives", new TableInfo.Column("LegumesallocatedMeatandalternatives", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("DairyandalternativesHEIFAscore", new TableInfo.Column("DairyandalternativesHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Dairyandalternativesservesize", new TableInfo.Column("Dairyandalternativesservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("SodiumHEIFAscore", new TableInfo.Column("SodiumHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Sodiummgmilligrams", new TableInfo.Column("Sodiummgmilligrams", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("AlcoholHEIFAscore", new TableInfo.Column("AlcoholHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Alcoholstandarddrinks", new TableInfo.Column("Alcoholstandarddrinks", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("WaterHEIFAscore", new TableInfo.Column("WaterHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Water", new TableInfo.Column("Water", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("WaterTotalmL", new TableInfo.Column("WaterTotalmL", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("BeverageTotalmL", new TableInfo.Column("BeverageTotalmL", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("SugarHEIFAscore", new TableInfo.Column("SugarHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("Sugar", new TableInfo.Column("Sugar", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("SaturatedFatHEIFAscore", new TableInfo.Column("SaturatedFatHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("SaturatedFat", new TableInfo.Column("SaturatedFat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("UnsaturatedFatHEIFAscore", new TableInfo.Column("UnsaturatedFatHEIFAscore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("UnsaturatedFatservesize", new TableInfo.Column("UnsaturatedFatservesize", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("questionnaire", new TableInfo.Column("questionnaire", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(db, "user");
        if (!_infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.fit2081.nutritrack_yinshi_34506241.data.User.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsFoodQuestionnaire = new HashMap<String, TableInfo.Column>(4);
        _columnsFoodQuestionnaire.put("questionnaireId", new TableInfo.Column("questionnaireId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodQuestionnaire.put("firstPartResult", new TableInfo.Column("firstPartResult", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodQuestionnaire.put("thirdPartResult", new TableInfo.Column("thirdPartResult", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFoodQuestionnaire.put("fourthPartResult", new TableInfo.Column("fourthPartResult", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodQuestionnaire = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysFoodQuestionnaire.add(new TableInfo.ForeignKey("user", "CASCADE", "NO ACTION", Arrays.asList("questionnaireId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesFoodQuestionnaire = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodQuestionnaire = new TableInfo("food_questionnaire", _columnsFoodQuestionnaire, _foreignKeysFoodQuestionnaire, _indicesFoodQuestionnaire);
        final TableInfo _existingFoodQuestionnaire = TableInfo.read(db, "food_questionnaire");
        if (!_infoFoodQuestionnaire.equals(_existingFoodQuestionnaire)) {
          return new RoomOpenHelper.ValidationResult(false, "food_questionnaire(com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireAnswers).\n"
                  + " Expected:\n" + _infoFoodQuestionnaire + "\n"
                  + " Found:\n" + _existingFoodQuestionnaire);
        }
        final HashMap<String, TableInfo.Column> _columnsAiResponse = new HashMap<String, TableInfo.Column>(7);
        _columnsAiResponse.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("promptTips", new TableInfo.Column("promptTips", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("promptFeedback", new TableInfo.Column("promptFeedback", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("tip", new TableInfo.Column("tip", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("feedback", new TableInfo.Column("feedback", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAiResponse.put("dateTime", new TableInfo.Column("dateTime", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAiResponse = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAiResponse.add(new TableInfo.ForeignKey("user", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAiResponse = new HashSet<TableInfo.Index>(1);
        _indicesAiResponse.add(new TableInfo.Index("index_ai_response_id", false, Arrays.asList("id"), Arrays.asList("ASC")));
        final TableInfo _infoAiResponse = new TableInfo("ai_response", _columnsAiResponse, _foreignKeysAiResponse, _indicesAiResponse);
        final TableInfo _existingAiResponse = TableInfo.read(db, "ai_response");
        if (!_infoAiResponse.equals(_existingAiResponse)) {
          return new RoomOpenHelper.ValidationResult(false, "ai_response(com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponse).\n"
                  + " Expected:\n" + _infoAiResponse + "\n"
                  + " Found:\n" + _existingAiResponse);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5a37afce95a6321a75047e6681c6acb1", "fae063149087c597176f46cd08039c0f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user","food_questionnaire","ai_response");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `food_questionnaire`");
      _db.execSQL("DELETE FROM `ai_response`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(QuestionnaireDao.class, QuestionnaireDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AIResponseDao.class, AIResponseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public QuestionnaireDao questionnaireDao() {
    if (_questionnaireDao != null) {
      return _questionnaireDao;
    } else {
      synchronized(this) {
        if(_questionnaireDao == null) {
          _questionnaireDao = new QuestionnaireDao_Impl(this);
        }
        return _questionnaireDao;
      }
    }
  }

  @Override
  public AIResponseDao aiResponseDao() {
    if (_aIResponseDao != null) {
      return _aIResponseDao;
    } else {
      synchronized(this) {
        if(_aIResponseDao == null) {
          _aIResponseDao = new AIResponseDao_Impl(this);
        }
        return _aIResponseDao;
      }
    }
  }
}
