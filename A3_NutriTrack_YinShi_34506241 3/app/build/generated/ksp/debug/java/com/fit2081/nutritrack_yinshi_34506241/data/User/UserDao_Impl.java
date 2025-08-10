package com.fit2081.nutritrack_yinshi_34506241.data.User;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllUsers;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserPassword;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserQuestionnaireProcess;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user` (`id`,`phoneNumber`,`sex`,`HEIFAtotalscore`,`DiscretionaryHEIFAscore`,`Discretionaryservesize`,`VegetablesHEIFAscore`,`Vegetableswithlegumesallocatedservesize`,`LegumesallocatedVegetables`,`Vegetablesvariationsscore`,`VegetablesCruciferous`,`VegetablesTuberandbulb`,`VegetablesOther`,`Legumes`,`VegetablesGreen`,`VegetablesRedandorange`,`FruitHEIFAscore`,`Fruitserversize`,`Fruitvariationsscore`,`FruitPome`,`FruitTropicalandsubtropical`,`FruitBerry`,`FruitStone`,`FruitCitrus`,`FruitOther`,`GrainsandcerealsHEIFAscore`,`Grainsandcerealsservesize`,`GrainsandcerealsNonwholegrains`,`WholegrainsHEIFAscore`,`Wholegrainsservesize`,`MeatandalternativesHEIFAscore`,`Meatandalternativeswithlegumesallocatedservesize`,`LegumesallocatedMeatandalternatives`,`DairyandalternativesHEIFAscore`,`Dairyandalternativesservesize`,`SodiumHEIFAscore`,`Sodiummgmilligrams`,`AlcoholHEIFAscore`,`Alcoholstandarddrinks`,`WaterHEIFAscore`,`Water`,`WaterTotalmL`,`BeverageTotalmL`,`SugarHEIFAscore`,`Sugar`,`SaturatedFatHEIFAscore`,`SaturatedFat`,`UnsaturatedFatHEIFAscore`,`UnsaturatedFatservesize`,`questionnaire`,`password`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPhoneNumber());
        statement.bindString(3, entity.getSex());
        statement.bindDouble(4, entity.getHEIFAtotalscore());
        statement.bindDouble(5, entity.getDiscretionaryHEIFAscore());
        statement.bindDouble(6, entity.getDiscretionaryservesize());
        statement.bindDouble(7, entity.getVegetablesHEIFAscore());
        statement.bindDouble(8, entity.getVegetableswithlegumesallocatedservesize());
        statement.bindDouble(9, entity.getLegumesallocatedVegetables());
        statement.bindDouble(10, entity.getVegetablesvariationsscore());
        statement.bindDouble(11, entity.getVegetablesCruciferous());
        statement.bindDouble(12, entity.getVegetablesTuberandbulb());
        statement.bindDouble(13, entity.getVegetablesOther());
        statement.bindDouble(14, entity.getLegumes());
        statement.bindDouble(15, entity.getVegetablesGreen());
        statement.bindDouble(16, entity.getVegetablesRedandorange());
        statement.bindDouble(17, entity.getFruitHEIFAscore());
        statement.bindDouble(18, entity.getFruitserversize());
        statement.bindDouble(19, entity.getFruitvariationsscore());
        statement.bindDouble(20, entity.getFruitPome());
        statement.bindDouble(21, entity.getFruitTropicalandsubtropical());
        statement.bindDouble(22, entity.getFruitBerry());
        statement.bindDouble(23, entity.getFruitStone());
        statement.bindDouble(24, entity.getFruitCitrus());
        statement.bindDouble(25, entity.getFruitOther());
        statement.bindDouble(26, entity.getGrainsandcerealsHEIFAscore());
        statement.bindDouble(27, entity.getGrainsandcerealsservesize());
        statement.bindDouble(28, entity.getGrainsandcerealsNonwholegrains());
        statement.bindDouble(29, entity.getWholegrainsHEIFAscore());
        statement.bindDouble(30, entity.getWholegrainsservesize());
        statement.bindDouble(31, entity.getMeatandalternativesHEIFAscore());
        statement.bindDouble(32, entity.getMeatandalternativeswithlegumesallocatedservesize());
        statement.bindDouble(33, entity.getLegumesallocatedMeatandalternatives());
        statement.bindDouble(34, entity.getDairyandalternativesHEIFAscore());
        statement.bindDouble(35, entity.getDairyandalternativesservesize());
        statement.bindDouble(36, entity.getSodiumHEIFAscore());
        statement.bindDouble(37, entity.getSodiummgmilligrams());
        statement.bindDouble(38, entity.getAlcoholHEIFAscore());
        statement.bindDouble(39, entity.getAlcoholstandarddrinks());
        statement.bindDouble(40, entity.getWaterHEIFAscore());
        statement.bindDouble(41, entity.getWater());
        statement.bindDouble(42, entity.getWaterTotalmL());
        statement.bindDouble(43, entity.getBeverageTotalmL());
        statement.bindDouble(44, entity.getSugarHEIFAscore());
        statement.bindDouble(45, entity.getSugar());
        statement.bindDouble(46, entity.getSaturatedFatHEIFAscore());
        statement.bindDouble(47, entity.getSaturatedFat());
        statement.bindDouble(48, entity.getUnsaturatedFatHEIFAscore());
        statement.bindDouble(49, entity.getUnsaturatedFatservesize());
        final int _tmp = entity.getQuestionnaire() ? 1 : 0;
        statement.bindLong(50, _tmp);
        if (entity.getPassword() == null) {
          statement.bindNull(51);
        } else {
          statement.bindString(51, entity.getPassword());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `user` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user` SET `id` = ?,`phoneNumber` = ?,`sex` = ?,`HEIFAtotalscore` = ?,`DiscretionaryHEIFAscore` = ?,`Discretionaryservesize` = ?,`VegetablesHEIFAscore` = ?,`Vegetableswithlegumesallocatedservesize` = ?,`LegumesallocatedVegetables` = ?,`Vegetablesvariationsscore` = ?,`VegetablesCruciferous` = ?,`VegetablesTuberandbulb` = ?,`VegetablesOther` = ?,`Legumes` = ?,`VegetablesGreen` = ?,`VegetablesRedandorange` = ?,`FruitHEIFAscore` = ?,`Fruitserversize` = ?,`Fruitvariationsscore` = ?,`FruitPome` = ?,`FruitTropicalandsubtropical` = ?,`FruitBerry` = ?,`FruitStone` = ?,`FruitCitrus` = ?,`FruitOther` = ?,`GrainsandcerealsHEIFAscore` = ?,`Grainsandcerealsservesize` = ?,`GrainsandcerealsNonwholegrains` = ?,`WholegrainsHEIFAscore` = ?,`Wholegrainsservesize` = ?,`MeatandalternativesHEIFAscore` = ?,`Meatandalternativeswithlegumesallocatedservesize` = ?,`LegumesallocatedMeatandalternatives` = ?,`DairyandalternativesHEIFAscore` = ?,`Dairyandalternativesservesize` = ?,`SodiumHEIFAscore` = ?,`Sodiummgmilligrams` = ?,`AlcoholHEIFAscore` = ?,`Alcoholstandarddrinks` = ?,`WaterHEIFAscore` = ?,`Water` = ?,`WaterTotalmL` = ?,`BeverageTotalmL` = ?,`SugarHEIFAscore` = ?,`Sugar` = ?,`SaturatedFatHEIFAscore` = ?,`SaturatedFat` = ?,`UnsaturatedFatHEIFAscore` = ?,`UnsaturatedFatservesize` = ?,`questionnaire` = ?,`password` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final User entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPhoneNumber());
        statement.bindString(3, entity.getSex());
        statement.bindDouble(4, entity.getHEIFAtotalscore());
        statement.bindDouble(5, entity.getDiscretionaryHEIFAscore());
        statement.bindDouble(6, entity.getDiscretionaryservesize());
        statement.bindDouble(7, entity.getVegetablesHEIFAscore());
        statement.bindDouble(8, entity.getVegetableswithlegumesallocatedservesize());
        statement.bindDouble(9, entity.getLegumesallocatedVegetables());
        statement.bindDouble(10, entity.getVegetablesvariationsscore());
        statement.bindDouble(11, entity.getVegetablesCruciferous());
        statement.bindDouble(12, entity.getVegetablesTuberandbulb());
        statement.bindDouble(13, entity.getVegetablesOther());
        statement.bindDouble(14, entity.getLegumes());
        statement.bindDouble(15, entity.getVegetablesGreen());
        statement.bindDouble(16, entity.getVegetablesRedandorange());
        statement.bindDouble(17, entity.getFruitHEIFAscore());
        statement.bindDouble(18, entity.getFruitserversize());
        statement.bindDouble(19, entity.getFruitvariationsscore());
        statement.bindDouble(20, entity.getFruitPome());
        statement.bindDouble(21, entity.getFruitTropicalandsubtropical());
        statement.bindDouble(22, entity.getFruitBerry());
        statement.bindDouble(23, entity.getFruitStone());
        statement.bindDouble(24, entity.getFruitCitrus());
        statement.bindDouble(25, entity.getFruitOther());
        statement.bindDouble(26, entity.getGrainsandcerealsHEIFAscore());
        statement.bindDouble(27, entity.getGrainsandcerealsservesize());
        statement.bindDouble(28, entity.getGrainsandcerealsNonwholegrains());
        statement.bindDouble(29, entity.getWholegrainsHEIFAscore());
        statement.bindDouble(30, entity.getWholegrainsservesize());
        statement.bindDouble(31, entity.getMeatandalternativesHEIFAscore());
        statement.bindDouble(32, entity.getMeatandalternativeswithlegumesallocatedservesize());
        statement.bindDouble(33, entity.getLegumesallocatedMeatandalternatives());
        statement.bindDouble(34, entity.getDairyandalternativesHEIFAscore());
        statement.bindDouble(35, entity.getDairyandalternativesservesize());
        statement.bindDouble(36, entity.getSodiumHEIFAscore());
        statement.bindDouble(37, entity.getSodiummgmilligrams());
        statement.bindDouble(38, entity.getAlcoholHEIFAscore());
        statement.bindDouble(39, entity.getAlcoholstandarddrinks());
        statement.bindDouble(40, entity.getWaterHEIFAscore());
        statement.bindDouble(41, entity.getWater());
        statement.bindDouble(42, entity.getWaterTotalmL());
        statement.bindDouble(43, entity.getBeverageTotalmL());
        statement.bindDouble(44, entity.getSugarHEIFAscore());
        statement.bindDouble(45, entity.getSugar());
        statement.bindDouble(46, entity.getSaturatedFatHEIFAscore());
        statement.bindDouble(47, entity.getSaturatedFat());
        statement.bindDouble(48, entity.getUnsaturatedFatHEIFAscore());
        statement.bindDouble(49, entity.getUnsaturatedFatservesize());
        final int _tmp = entity.getQuestionnaire() ? 1 : 0;
        statement.bindLong(50, _tmp);
        if (entity.getPassword() == null) {
          statement.bindNull(51);
        } else {
          statement.bindString(51, entity.getPassword());
        }
        statement.bindString(52, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM user";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserPassword = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user SET password = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserQuestionnaireProcess = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user SET questionnaire = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<User> users, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUser.insert(users);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final User user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUser.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllUsers.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserPassword(final String uid, final String newPassword,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserPassword.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, newPassword);
        _argIndex = 2;
        _stmt.bindString(_argIndex, uid);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateUserPassword.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserQuestionnaireProcess(final String uid, final boolean questionnaireProcess,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserQuestionnaireProcess.acquire();
        int _argIndex = 1;
        final int _tmp = questionnaireProcess ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindString(_argIndex, uid);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateUserQuestionnaireProcess.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<User>> getAllUsers() {
    final String _sql = "SELECT * FROM user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user"}, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
          final int _cursorIndexOfHEIFAtotalscore = CursorUtil.getColumnIndexOrThrow(_cursor, "HEIFAtotalscore");
          final int _cursorIndexOfDiscretionaryHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DiscretionaryHEIFAscore");
          final int _cursorIndexOfDiscretionaryservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Discretionaryservesize");
          final int _cursorIndexOfVegetablesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesHEIFAscore");
          final int _cursorIndexOfVegetableswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetableswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedVegetables = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedVegetables");
          final int _cursorIndexOfVegetablesvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetablesvariationsscore");
          final int _cursorIndexOfVegetablesCruciferous = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesCruciferous");
          final int _cursorIndexOfVegetablesTuberandbulb = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesTuberandbulb");
          final int _cursorIndexOfVegetablesOther = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesOther");
          final int _cursorIndexOfLegumes = CursorUtil.getColumnIndexOrThrow(_cursor, "Legumes");
          final int _cursorIndexOfVegetablesGreen = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesGreen");
          final int _cursorIndexOfVegetablesRedandorange = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesRedandorange");
          final int _cursorIndexOfFruitHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitHEIFAscore");
          final int _cursorIndexOfFruitserversize = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitserversize");
          final int _cursorIndexOfFruitvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitvariationsscore");
          final int _cursorIndexOfFruitPome = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitPome");
          final int _cursorIndexOfFruitTropicalandsubtropical = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitTropicalandsubtropical");
          final int _cursorIndexOfFruitBerry = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitBerry");
          final int _cursorIndexOfFruitStone = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitStone");
          final int _cursorIndexOfFruitCitrus = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitCitrus");
          final int _cursorIndexOfFruitOther = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitOther");
          final int _cursorIndexOfGrainsandcerealsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsHEIFAscore");
          final int _cursorIndexOfGrainsandcerealsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Grainsandcerealsservesize");
          final int _cursorIndexOfGrainsandcerealsNonwholegrains = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsNonwholegrains");
          final int _cursorIndexOfWholegrainsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WholegrainsHEIFAscore");
          final int _cursorIndexOfWholegrainsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Wholegrainsservesize");
          final int _cursorIndexOfMeatandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "MeatandalternativesHEIFAscore");
          final int _cursorIndexOfMeatandalternativeswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Meatandalternativeswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedMeatandalternatives = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedMeatandalternatives");
          final int _cursorIndexOfDairyandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DairyandalternativesHEIFAscore");
          final int _cursorIndexOfDairyandalternativesservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Dairyandalternativesservesize");
          final int _cursorIndexOfSodiumHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SodiumHEIFAscore");
          final int _cursorIndexOfSodiummgmilligrams = CursorUtil.getColumnIndexOrThrow(_cursor, "Sodiummgmilligrams");
          final int _cursorIndexOfAlcoholHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "AlcoholHEIFAscore");
          final int _cursorIndexOfAlcoholstandarddrinks = CursorUtil.getColumnIndexOrThrow(_cursor, "Alcoholstandarddrinks");
          final int _cursorIndexOfWaterHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterHEIFAscore");
          final int _cursorIndexOfWater = CursorUtil.getColumnIndexOrThrow(_cursor, "Water");
          final int _cursorIndexOfWaterTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterTotalmL");
          final int _cursorIndexOfBeverageTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "BeverageTotalmL");
          final int _cursorIndexOfSugarHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SugarHEIFAscore");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "Sugar");
          final int _cursorIndexOfSaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFatHEIFAscore");
          final int _cursorIndexOfSaturatedFat = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFat");
          final int _cursorIndexOfUnsaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatHEIFAscore");
          final int _cursorIndexOfUnsaturatedFatservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatservesize");
          final int _cursorIndexOfQuestionnaire = CursorUtil.getColumnIndexOrThrow(_cursor, "questionnaire");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPhoneNumber;
            _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            final String _tmpSex;
            _tmpSex = _cursor.getString(_cursorIndexOfSex);
            final double _tmpHEIFAtotalscore;
            _tmpHEIFAtotalscore = _cursor.getDouble(_cursorIndexOfHEIFAtotalscore);
            final double _tmpDiscretionaryHEIFAscore;
            _tmpDiscretionaryHEIFAscore = _cursor.getDouble(_cursorIndexOfDiscretionaryHEIFAscore);
            final double _tmpDiscretionaryservesize;
            _tmpDiscretionaryservesize = _cursor.getDouble(_cursorIndexOfDiscretionaryservesize);
            final double _tmpVegetablesHEIFAscore;
            _tmpVegetablesHEIFAscore = _cursor.getDouble(_cursorIndexOfVegetablesHEIFAscore);
            final double _tmpVegetableswithlegumesallocatedservesize;
            _tmpVegetableswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfVegetableswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedVegetables;
            _tmpLegumesallocatedVegetables = _cursor.getDouble(_cursorIndexOfLegumesallocatedVegetables);
            final double _tmpVegetablesvariationsscore;
            _tmpVegetablesvariationsscore = _cursor.getDouble(_cursorIndexOfVegetablesvariationsscore);
            final double _tmpVegetablesCruciferous;
            _tmpVegetablesCruciferous = _cursor.getDouble(_cursorIndexOfVegetablesCruciferous);
            final double _tmpVegetablesTuberandbulb;
            _tmpVegetablesTuberandbulb = _cursor.getDouble(_cursorIndexOfVegetablesTuberandbulb);
            final double _tmpVegetablesOther;
            _tmpVegetablesOther = _cursor.getDouble(_cursorIndexOfVegetablesOther);
            final double _tmpLegumes;
            _tmpLegumes = _cursor.getDouble(_cursorIndexOfLegumes);
            final double _tmpVegetablesGreen;
            _tmpVegetablesGreen = _cursor.getDouble(_cursorIndexOfVegetablesGreen);
            final double _tmpVegetablesRedandorange;
            _tmpVegetablesRedandorange = _cursor.getDouble(_cursorIndexOfVegetablesRedandorange);
            final double _tmpFruitHEIFAscore;
            _tmpFruitHEIFAscore = _cursor.getDouble(_cursorIndexOfFruitHEIFAscore);
            final double _tmpFruitserversize;
            _tmpFruitserversize = _cursor.getDouble(_cursorIndexOfFruitserversize);
            final double _tmpFruitvariationsscore;
            _tmpFruitvariationsscore = _cursor.getDouble(_cursorIndexOfFruitvariationsscore);
            final double _tmpFruitPome;
            _tmpFruitPome = _cursor.getDouble(_cursorIndexOfFruitPome);
            final double _tmpFruitTropicalandsubtropical;
            _tmpFruitTropicalandsubtropical = _cursor.getDouble(_cursorIndexOfFruitTropicalandsubtropical);
            final double _tmpFruitBerry;
            _tmpFruitBerry = _cursor.getDouble(_cursorIndexOfFruitBerry);
            final double _tmpFruitStone;
            _tmpFruitStone = _cursor.getDouble(_cursorIndexOfFruitStone);
            final double _tmpFruitCitrus;
            _tmpFruitCitrus = _cursor.getDouble(_cursorIndexOfFruitCitrus);
            final double _tmpFruitOther;
            _tmpFruitOther = _cursor.getDouble(_cursorIndexOfFruitOther);
            final double _tmpGrainsandcerealsHEIFAscore;
            _tmpGrainsandcerealsHEIFAscore = _cursor.getDouble(_cursorIndexOfGrainsandcerealsHEIFAscore);
            final double _tmpGrainsandcerealsservesize;
            _tmpGrainsandcerealsservesize = _cursor.getDouble(_cursorIndexOfGrainsandcerealsservesize);
            final double _tmpGrainsandcerealsNonwholegrains;
            _tmpGrainsandcerealsNonwholegrains = _cursor.getDouble(_cursorIndexOfGrainsandcerealsNonwholegrains);
            final double _tmpWholegrainsHEIFAscore;
            _tmpWholegrainsHEIFAscore = _cursor.getDouble(_cursorIndexOfWholegrainsHEIFAscore);
            final double _tmpWholegrainsservesize;
            _tmpWholegrainsservesize = _cursor.getDouble(_cursorIndexOfWholegrainsservesize);
            final double _tmpMeatandalternativesHEIFAscore;
            _tmpMeatandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfMeatandalternativesHEIFAscore);
            final double _tmpMeatandalternativeswithlegumesallocatedservesize;
            _tmpMeatandalternativeswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfMeatandalternativeswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedMeatandalternatives;
            _tmpLegumesallocatedMeatandalternatives = _cursor.getDouble(_cursorIndexOfLegumesallocatedMeatandalternatives);
            final double _tmpDairyandalternativesHEIFAscore;
            _tmpDairyandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfDairyandalternativesHEIFAscore);
            final double _tmpDairyandalternativesservesize;
            _tmpDairyandalternativesservesize = _cursor.getDouble(_cursorIndexOfDairyandalternativesservesize);
            final double _tmpSodiumHEIFAscore;
            _tmpSodiumHEIFAscore = _cursor.getDouble(_cursorIndexOfSodiumHEIFAscore);
            final double _tmpSodiummgmilligrams;
            _tmpSodiummgmilligrams = _cursor.getDouble(_cursorIndexOfSodiummgmilligrams);
            final double _tmpAlcoholHEIFAscore;
            _tmpAlcoholHEIFAscore = _cursor.getDouble(_cursorIndexOfAlcoholHEIFAscore);
            final double _tmpAlcoholstandarddrinks;
            _tmpAlcoholstandarddrinks = _cursor.getDouble(_cursorIndexOfAlcoholstandarddrinks);
            final double _tmpWaterHEIFAscore;
            _tmpWaterHEIFAscore = _cursor.getDouble(_cursorIndexOfWaterHEIFAscore);
            final double _tmpWater;
            _tmpWater = _cursor.getDouble(_cursorIndexOfWater);
            final double _tmpWaterTotalmL;
            _tmpWaterTotalmL = _cursor.getDouble(_cursorIndexOfWaterTotalmL);
            final double _tmpBeverageTotalmL;
            _tmpBeverageTotalmL = _cursor.getDouble(_cursorIndexOfBeverageTotalmL);
            final double _tmpSugarHEIFAscore;
            _tmpSugarHEIFAscore = _cursor.getDouble(_cursorIndexOfSugarHEIFAscore);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSaturatedFatHEIFAscore;
            _tmpSaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfSaturatedFatHEIFAscore);
            final double _tmpSaturatedFat;
            _tmpSaturatedFat = _cursor.getDouble(_cursorIndexOfSaturatedFat);
            final double _tmpUnsaturatedFatHEIFAscore;
            _tmpUnsaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfUnsaturatedFatHEIFAscore);
            final double _tmpUnsaturatedFatservesize;
            _tmpUnsaturatedFatservesize = _cursor.getDouble(_cursorIndexOfUnsaturatedFatservesize);
            final boolean _tmpQuestionnaire;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfQuestionnaire);
            _tmpQuestionnaire = _tmp != 0;
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _item = new User(_tmpId,_tmpPhoneNumber,_tmpSex,_tmpHEIFAtotalscore,_tmpDiscretionaryHEIFAscore,_tmpDiscretionaryservesize,_tmpVegetablesHEIFAscore,_tmpVegetableswithlegumesallocatedservesize,_tmpLegumesallocatedVegetables,_tmpVegetablesvariationsscore,_tmpVegetablesCruciferous,_tmpVegetablesTuberandbulb,_tmpVegetablesOther,_tmpLegumes,_tmpVegetablesGreen,_tmpVegetablesRedandorange,_tmpFruitHEIFAscore,_tmpFruitserversize,_tmpFruitvariationsscore,_tmpFruitPome,_tmpFruitTropicalandsubtropical,_tmpFruitBerry,_tmpFruitStone,_tmpFruitCitrus,_tmpFruitOther,_tmpGrainsandcerealsHEIFAscore,_tmpGrainsandcerealsservesize,_tmpGrainsandcerealsNonwholegrains,_tmpWholegrainsHEIFAscore,_tmpWholegrainsservesize,_tmpMeatandalternativesHEIFAscore,_tmpMeatandalternativeswithlegumesallocatedservesize,_tmpLegumesallocatedMeatandalternatives,_tmpDairyandalternativesHEIFAscore,_tmpDairyandalternativesservesize,_tmpSodiumHEIFAscore,_tmpSodiummgmilligrams,_tmpAlcoholHEIFAscore,_tmpAlcoholstandarddrinks,_tmpWaterHEIFAscore,_tmpWater,_tmpWaterTotalmL,_tmpBeverageTotalmL,_tmpSugarHEIFAscore,_tmpSugar,_tmpSaturatedFatHEIFAscore,_tmpSaturatedFat,_tmpUnsaturatedFatHEIFAscore,_tmpUnsaturatedFatservesize,_tmpQuestionnaire,_tmpPassword);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUserById(final String id, final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM user WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
          final int _cursorIndexOfHEIFAtotalscore = CursorUtil.getColumnIndexOrThrow(_cursor, "HEIFAtotalscore");
          final int _cursorIndexOfDiscretionaryHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DiscretionaryHEIFAscore");
          final int _cursorIndexOfDiscretionaryservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Discretionaryservesize");
          final int _cursorIndexOfVegetablesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesHEIFAscore");
          final int _cursorIndexOfVegetableswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetableswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedVegetables = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedVegetables");
          final int _cursorIndexOfVegetablesvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetablesvariationsscore");
          final int _cursorIndexOfVegetablesCruciferous = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesCruciferous");
          final int _cursorIndexOfVegetablesTuberandbulb = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesTuberandbulb");
          final int _cursorIndexOfVegetablesOther = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesOther");
          final int _cursorIndexOfLegumes = CursorUtil.getColumnIndexOrThrow(_cursor, "Legumes");
          final int _cursorIndexOfVegetablesGreen = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesGreen");
          final int _cursorIndexOfVegetablesRedandorange = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesRedandorange");
          final int _cursorIndexOfFruitHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitHEIFAscore");
          final int _cursorIndexOfFruitserversize = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitserversize");
          final int _cursorIndexOfFruitvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitvariationsscore");
          final int _cursorIndexOfFruitPome = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitPome");
          final int _cursorIndexOfFruitTropicalandsubtropical = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitTropicalandsubtropical");
          final int _cursorIndexOfFruitBerry = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitBerry");
          final int _cursorIndexOfFruitStone = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitStone");
          final int _cursorIndexOfFruitCitrus = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitCitrus");
          final int _cursorIndexOfFruitOther = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitOther");
          final int _cursorIndexOfGrainsandcerealsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsHEIFAscore");
          final int _cursorIndexOfGrainsandcerealsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Grainsandcerealsservesize");
          final int _cursorIndexOfGrainsandcerealsNonwholegrains = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsNonwholegrains");
          final int _cursorIndexOfWholegrainsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WholegrainsHEIFAscore");
          final int _cursorIndexOfWholegrainsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Wholegrainsservesize");
          final int _cursorIndexOfMeatandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "MeatandalternativesHEIFAscore");
          final int _cursorIndexOfMeatandalternativeswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Meatandalternativeswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedMeatandalternatives = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedMeatandalternatives");
          final int _cursorIndexOfDairyandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DairyandalternativesHEIFAscore");
          final int _cursorIndexOfDairyandalternativesservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Dairyandalternativesservesize");
          final int _cursorIndexOfSodiumHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SodiumHEIFAscore");
          final int _cursorIndexOfSodiummgmilligrams = CursorUtil.getColumnIndexOrThrow(_cursor, "Sodiummgmilligrams");
          final int _cursorIndexOfAlcoholHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "AlcoholHEIFAscore");
          final int _cursorIndexOfAlcoholstandarddrinks = CursorUtil.getColumnIndexOrThrow(_cursor, "Alcoholstandarddrinks");
          final int _cursorIndexOfWaterHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterHEIFAscore");
          final int _cursorIndexOfWater = CursorUtil.getColumnIndexOrThrow(_cursor, "Water");
          final int _cursorIndexOfWaterTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterTotalmL");
          final int _cursorIndexOfBeverageTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "BeverageTotalmL");
          final int _cursorIndexOfSugarHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SugarHEIFAscore");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "Sugar");
          final int _cursorIndexOfSaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFatHEIFAscore");
          final int _cursorIndexOfSaturatedFat = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFat");
          final int _cursorIndexOfUnsaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatHEIFAscore");
          final int _cursorIndexOfUnsaturatedFatservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatservesize");
          final int _cursorIndexOfQuestionnaire = CursorUtil.getColumnIndexOrThrow(_cursor, "questionnaire");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPhoneNumber;
            _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            final String _tmpSex;
            _tmpSex = _cursor.getString(_cursorIndexOfSex);
            final double _tmpHEIFAtotalscore;
            _tmpHEIFAtotalscore = _cursor.getDouble(_cursorIndexOfHEIFAtotalscore);
            final double _tmpDiscretionaryHEIFAscore;
            _tmpDiscretionaryHEIFAscore = _cursor.getDouble(_cursorIndexOfDiscretionaryHEIFAscore);
            final double _tmpDiscretionaryservesize;
            _tmpDiscretionaryservesize = _cursor.getDouble(_cursorIndexOfDiscretionaryservesize);
            final double _tmpVegetablesHEIFAscore;
            _tmpVegetablesHEIFAscore = _cursor.getDouble(_cursorIndexOfVegetablesHEIFAscore);
            final double _tmpVegetableswithlegumesallocatedservesize;
            _tmpVegetableswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfVegetableswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedVegetables;
            _tmpLegumesallocatedVegetables = _cursor.getDouble(_cursorIndexOfLegumesallocatedVegetables);
            final double _tmpVegetablesvariationsscore;
            _tmpVegetablesvariationsscore = _cursor.getDouble(_cursorIndexOfVegetablesvariationsscore);
            final double _tmpVegetablesCruciferous;
            _tmpVegetablesCruciferous = _cursor.getDouble(_cursorIndexOfVegetablesCruciferous);
            final double _tmpVegetablesTuberandbulb;
            _tmpVegetablesTuberandbulb = _cursor.getDouble(_cursorIndexOfVegetablesTuberandbulb);
            final double _tmpVegetablesOther;
            _tmpVegetablesOther = _cursor.getDouble(_cursorIndexOfVegetablesOther);
            final double _tmpLegumes;
            _tmpLegumes = _cursor.getDouble(_cursorIndexOfLegumes);
            final double _tmpVegetablesGreen;
            _tmpVegetablesGreen = _cursor.getDouble(_cursorIndexOfVegetablesGreen);
            final double _tmpVegetablesRedandorange;
            _tmpVegetablesRedandorange = _cursor.getDouble(_cursorIndexOfVegetablesRedandorange);
            final double _tmpFruitHEIFAscore;
            _tmpFruitHEIFAscore = _cursor.getDouble(_cursorIndexOfFruitHEIFAscore);
            final double _tmpFruitserversize;
            _tmpFruitserversize = _cursor.getDouble(_cursorIndexOfFruitserversize);
            final double _tmpFruitvariationsscore;
            _tmpFruitvariationsscore = _cursor.getDouble(_cursorIndexOfFruitvariationsscore);
            final double _tmpFruitPome;
            _tmpFruitPome = _cursor.getDouble(_cursorIndexOfFruitPome);
            final double _tmpFruitTropicalandsubtropical;
            _tmpFruitTropicalandsubtropical = _cursor.getDouble(_cursorIndexOfFruitTropicalandsubtropical);
            final double _tmpFruitBerry;
            _tmpFruitBerry = _cursor.getDouble(_cursorIndexOfFruitBerry);
            final double _tmpFruitStone;
            _tmpFruitStone = _cursor.getDouble(_cursorIndexOfFruitStone);
            final double _tmpFruitCitrus;
            _tmpFruitCitrus = _cursor.getDouble(_cursorIndexOfFruitCitrus);
            final double _tmpFruitOther;
            _tmpFruitOther = _cursor.getDouble(_cursorIndexOfFruitOther);
            final double _tmpGrainsandcerealsHEIFAscore;
            _tmpGrainsandcerealsHEIFAscore = _cursor.getDouble(_cursorIndexOfGrainsandcerealsHEIFAscore);
            final double _tmpGrainsandcerealsservesize;
            _tmpGrainsandcerealsservesize = _cursor.getDouble(_cursorIndexOfGrainsandcerealsservesize);
            final double _tmpGrainsandcerealsNonwholegrains;
            _tmpGrainsandcerealsNonwholegrains = _cursor.getDouble(_cursorIndexOfGrainsandcerealsNonwholegrains);
            final double _tmpWholegrainsHEIFAscore;
            _tmpWholegrainsHEIFAscore = _cursor.getDouble(_cursorIndexOfWholegrainsHEIFAscore);
            final double _tmpWholegrainsservesize;
            _tmpWholegrainsservesize = _cursor.getDouble(_cursorIndexOfWholegrainsservesize);
            final double _tmpMeatandalternativesHEIFAscore;
            _tmpMeatandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfMeatandalternativesHEIFAscore);
            final double _tmpMeatandalternativeswithlegumesallocatedservesize;
            _tmpMeatandalternativeswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfMeatandalternativeswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedMeatandalternatives;
            _tmpLegumesallocatedMeatandalternatives = _cursor.getDouble(_cursorIndexOfLegumesallocatedMeatandalternatives);
            final double _tmpDairyandalternativesHEIFAscore;
            _tmpDairyandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfDairyandalternativesHEIFAscore);
            final double _tmpDairyandalternativesservesize;
            _tmpDairyandalternativesservesize = _cursor.getDouble(_cursorIndexOfDairyandalternativesservesize);
            final double _tmpSodiumHEIFAscore;
            _tmpSodiumHEIFAscore = _cursor.getDouble(_cursorIndexOfSodiumHEIFAscore);
            final double _tmpSodiummgmilligrams;
            _tmpSodiummgmilligrams = _cursor.getDouble(_cursorIndexOfSodiummgmilligrams);
            final double _tmpAlcoholHEIFAscore;
            _tmpAlcoholHEIFAscore = _cursor.getDouble(_cursorIndexOfAlcoholHEIFAscore);
            final double _tmpAlcoholstandarddrinks;
            _tmpAlcoholstandarddrinks = _cursor.getDouble(_cursorIndexOfAlcoholstandarddrinks);
            final double _tmpWaterHEIFAscore;
            _tmpWaterHEIFAscore = _cursor.getDouble(_cursorIndexOfWaterHEIFAscore);
            final double _tmpWater;
            _tmpWater = _cursor.getDouble(_cursorIndexOfWater);
            final double _tmpWaterTotalmL;
            _tmpWaterTotalmL = _cursor.getDouble(_cursorIndexOfWaterTotalmL);
            final double _tmpBeverageTotalmL;
            _tmpBeverageTotalmL = _cursor.getDouble(_cursorIndexOfBeverageTotalmL);
            final double _tmpSugarHEIFAscore;
            _tmpSugarHEIFAscore = _cursor.getDouble(_cursorIndexOfSugarHEIFAscore);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSaturatedFatHEIFAscore;
            _tmpSaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfSaturatedFatHEIFAscore);
            final double _tmpSaturatedFat;
            _tmpSaturatedFat = _cursor.getDouble(_cursorIndexOfSaturatedFat);
            final double _tmpUnsaturatedFatHEIFAscore;
            _tmpUnsaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfUnsaturatedFatHEIFAscore);
            final double _tmpUnsaturatedFatservesize;
            _tmpUnsaturatedFatservesize = _cursor.getDouble(_cursorIndexOfUnsaturatedFatservesize);
            final boolean _tmpQuestionnaire;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfQuestionnaire);
            _tmpQuestionnaire = _tmp != 0;
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new User(_tmpId,_tmpPhoneNumber,_tmpSex,_tmpHEIFAtotalscore,_tmpDiscretionaryHEIFAscore,_tmpDiscretionaryservesize,_tmpVegetablesHEIFAscore,_tmpVegetableswithlegumesallocatedservesize,_tmpLegumesallocatedVegetables,_tmpVegetablesvariationsscore,_tmpVegetablesCruciferous,_tmpVegetablesTuberandbulb,_tmpVegetablesOther,_tmpLegumes,_tmpVegetablesGreen,_tmpVegetablesRedandorange,_tmpFruitHEIFAscore,_tmpFruitserversize,_tmpFruitvariationsscore,_tmpFruitPome,_tmpFruitTropicalandsubtropical,_tmpFruitBerry,_tmpFruitStone,_tmpFruitCitrus,_tmpFruitOther,_tmpGrainsandcerealsHEIFAscore,_tmpGrainsandcerealsservesize,_tmpGrainsandcerealsNonwholegrains,_tmpWholegrainsHEIFAscore,_tmpWholegrainsservesize,_tmpMeatandalternativesHEIFAscore,_tmpMeatandalternativeswithlegumesallocatedservesize,_tmpLegumesallocatedMeatandalternatives,_tmpDairyandalternativesHEIFAscore,_tmpDairyandalternativesservesize,_tmpSodiumHEIFAscore,_tmpSodiummgmilligrams,_tmpAlcoholHEIFAscore,_tmpAlcoholstandarddrinks,_tmpWaterHEIFAscore,_tmpWater,_tmpWaterTotalmL,_tmpBeverageTotalmL,_tmpSugarHEIFAscore,_tmpSugar,_tmpSaturatedFatHEIFAscore,_tmpSaturatedFat,_tmpUnsaturatedFatHEIFAscore,_tmpUnsaturatedFatservesize,_tmpQuestionnaire,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserByPhoneNumber(final String phoneNumber,
      final Continuation<? super User> $completion) {
    final String _sql = "SELECT * FROM user WHERE phoneNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, phoneNumber);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<User>() {
      @Override
      @Nullable
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
          final int _cursorIndexOfHEIFAtotalscore = CursorUtil.getColumnIndexOrThrow(_cursor, "HEIFAtotalscore");
          final int _cursorIndexOfDiscretionaryHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DiscretionaryHEIFAscore");
          final int _cursorIndexOfDiscretionaryservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Discretionaryservesize");
          final int _cursorIndexOfVegetablesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesHEIFAscore");
          final int _cursorIndexOfVegetableswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetableswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedVegetables = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedVegetables");
          final int _cursorIndexOfVegetablesvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetablesvariationsscore");
          final int _cursorIndexOfVegetablesCruciferous = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesCruciferous");
          final int _cursorIndexOfVegetablesTuberandbulb = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesTuberandbulb");
          final int _cursorIndexOfVegetablesOther = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesOther");
          final int _cursorIndexOfLegumes = CursorUtil.getColumnIndexOrThrow(_cursor, "Legumes");
          final int _cursorIndexOfVegetablesGreen = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesGreen");
          final int _cursorIndexOfVegetablesRedandorange = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesRedandorange");
          final int _cursorIndexOfFruitHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitHEIFAscore");
          final int _cursorIndexOfFruitserversize = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitserversize");
          final int _cursorIndexOfFruitvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitvariationsscore");
          final int _cursorIndexOfFruitPome = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitPome");
          final int _cursorIndexOfFruitTropicalandsubtropical = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitTropicalandsubtropical");
          final int _cursorIndexOfFruitBerry = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitBerry");
          final int _cursorIndexOfFruitStone = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitStone");
          final int _cursorIndexOfFruitCitrus = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitCitrus");
          final int _cursorIndexOfFruitOther = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitOther");
          final int _cursorIndexOfGrainsandcerealsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsHEIFAscore");
          final int _cursorIndexOfGrainsandcerealsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Grainsandcerealsservesize");
          final int _cursorIndexOfGrainsandcerealsNonwholegrains = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsNonwholegrains");
          final int _cursorIndexOfWholegrainsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WholegrainsHEIFAscore");
          final int _cursorIndexOfWholegrainsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Wholegrainsservesize");
          final int _cursorIndexOfMeatandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "MeatandalternativesHEIFAscore");
          final int _cursorIndexOfMeatandalternativeswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Meatandalternativeswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedMeatandalternatives = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedMeatandalternatives");
          final int _cursorIndexOfDairyandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DairyandalternativesHEIFAscore");
          final int _cursorIndexOfDairyandalternativesservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Dairyandalternativesservesize");
          final int _cursorIndexOfSodiumHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SodiumHEIFAscore");
          final int _cursorIndexOfSodiummgmilligrams = CursorUtil.getColumnIndexOrThrow(_cursor, "Sodiummgmilligrams");
          final int _cursorIndexOfAlcoholHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "AlcoholHEIFAscore");
          final int _cursorIndexOfAlcoholstandarddrinks = CursorUtil.getColumnIndexOrThrow(_cursor, "Alcoholstandarddrinks");
          final int _cursorIndexOfWaterHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterHEIFAscore");
          final int _cursorIndexOfWater = CursorUtil.getColumnIndexOrThrow(_cursor, "Water");
          final int _cursorIndexOfWaterTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterTotalmL");
          final int _cursorIndexOfBeverageTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "BeverageTotalmL");
          final int _cursorIndexOfSugarHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SugarHEIFAscore");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "Sugar");
          final int _cursorIndexOfSaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFatHEIFAscore");
          final int _cursorIndexOfSaturatedFat = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFat");
          final int _cursorIndexOfUnsaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatHEIFAscore");
          final int _cursorIndexOfUnsaturatedFatservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatservesize");
          final int _cursorIndexOfQuestionnaire = CursorUtil.getColumnIndexOrThrow(_cursor, "questionnaire");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final User _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPhoneNumber;
            _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            final String _tmpSex;
            _tmpSex = _cursor.getString(_cursorIndexOfSex);
            final double _tmpHEIFAtotalscore;
            _tmpHEIFAtotalscore = _cursor.getDouble(_cursorIndexOfHEIFAtotalscore);
            final double _tmpDiscretionaryHEIFAscore;
            _tmpDiscretionaryHEIFAscore = _cursor.getDouble(_cursorIndexOfDiscretionaryHEIFAscore);
            final double _tmpDiscretionaryservesize;
            _tmpDiscretionaryservesize = _cursor.getDouble(_cursorIndexOfDiscretionaryservesize);
            final double _tmpVegetablesHEIFAscore;
            _tmpVegetablesHEIFAscore = _cursor.getDouble(_cursorIndexOfVegetablesHEIFAscore);
            final double _tmpVegetableswithlegumesallocatedservesize;
            _tmpVegetableswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfVegetableswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedVegetables;
            _tmpLegumesallocatedVegetables = _cursor.getDouble(_cursorIndexOfLegumesallocatedVegetables);
            final double _tmpVegetablesvariationsscore;
            _tmpVegetablesvariationsscore = _cursor.getDouble(_cursorIndexOfVegetablesvariationsscore);
            final double _tmpVegetablesCruciferous;
            _tmpVegetablesCruciferous = _cursor.getDouble(_cursorIndexOfVegetablesCruciferous);
            final double _tmpVegetablesTuberandbulb;
            _tmpVegetablesTuberandbulb = _cursor.getDouble(_cursorIndexOfVegetablesTuberandbulb);
            final double _tmpVegetablesOther;
            _tmpVegetablesOther = _cursor.getDouble(_cursorIndexOfVegetablesOther);
            final double _tmpLegumes;
            _tmpLegumes = _cursor.getDouble(_cursorIndexOfLegumes);
            final double _tmpVegetablesGreen;
            _tmpVegetablesGreen = _cursor.getDouble(_cursorIndexOfVegetablesGreen);
            final double _tmpVegetablesRedandorange;
            _tmpVegetablesRedandorange = _cursor.getDouble(_cursorIndexOfVegetablesRedandorange);
            final double _tmpFruitHEIFAscore;
            _tmpFruitHEIFAscore = _cursor.getDouble(_cursorIndexOfFruitHEIFAscore);
            final double _tmpFruitserversize;
            _tmpFruitserversize = _cursor.getDouble(_cursorIndexOfFruitserversize);
            final double _tmpFruitvariationsscore;
            _tmpFruitvariationsscore = _cursor.getDouble(_cursorIndexOfFruitvariationsscore);
            final double _tmpFruitPome;
            _tmpFruitPome = _cursor.getDouble(_cursorIndexOfFruitPome);
            final double _tmpFruitTropicalandsubtropical;
            _tmpFruitTropicalandsubtropical = _cursor.getDouble(_cursorIndexOfFruitTropicalandsubtropical);
            final double _tmpFruitBerry;
            _tmpFruitBerry = _cursor.getDouble(_cursorIndexOfFruitBerry);
            final double _tmpFruitStone;
            _tmpFruitStone = _cursor.getDouble(_cursorIndexOfFruitStone);
            final double _tmpFruitCitrus;
            _tmpFruitCitrus = _cursor.getDouble(_cursorIndexOfFruitCitrus);
            final double _tmpFruitOther;
            _tmpFruitOther = _cursor.getDouble(_cursorIndexOfFruitOther);
            final double _tmpGrainsandcerealsHEIFAscore;
            _tmpGrainsandcerealsHEIFAscore = _cursor.getDouble(_cursorIndexOfGrainsandcerealsHEIFAscore);
            final double _tmpGrainsandcerealsservesize;
            _tmpGrainsandcerealsservesize = _cursor.getDouble(_cursorIndexOfGrainsandcerealsservesize);
            final double _tmpGrainsandcerealsNonwholegrains;
            _tmpGrainsandcerealsNonwholegrains = _cursor.getDouble(_cursorIndexOfGrainsandcerealsNonwholegrains);
            final double _tmpWholegrainsHEIFAscore;
            _tmpWholegrainsHEIFAscore = _cursor.getDouble(_cursorIndexOfWholegrainsHEIFAscore);
            final double _tmpWholegrainsservesize;
            _tmpWholegrainsservesize = _cursor.getDouble(_cursorIndexOfWholegrainsservesize);
            final double _tmpMeatandalternativesHEIFAscore;
            _tmpMeatandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfMeatandalternativesHEIFAscore);
            final double _tmpMeatandalternativeswithlegumesallocatedservesize;
            _tmpMeatandalternativeswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfMeatandalternativeswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedMeatandalternatives;
            _tmpLegumesallocatedMeatandalternatives = _cursor.getDouble(_cursorIndexOfLegumesallocatedMeatandalternatives);
            final double _tmpDairyandalternativesHEIFAscore;
            _tmpDairyandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfDairyandalternativesHEIFAscore);
            final double _tmpDairyandalternativesservesize;
            _tmpDairyandalternativesservesize = _cursor.getDouble(_cursorIndexOfDairyandalternativesservesize);
            final double _tmpSodiumHEIFAscore;
            _tmpSodiumHEIFAscore = _cursor.getDouble(_cursorIndexOfSodiumHEIFAscore);
            final double _tmpSodiummgmilligrams;
            _tmpSodiummgmilligrams = _cursor.getDouble(_cursorIndexOfSodiummgmilligrams);
            final double _tmpAlcoholHEIFAscore;
            _tmpAlcoholHEIFAscore = _cursor.getDouble(_cursorIndexOfAlcoholHEIFAscore);
            final double _tmpAlcoholstandarddrinks;
            _tmpAlcoholstandarddrinks = _cursor.getDouble(_cursorIndexOfAlcoholstandarddrinks);
            final double _tmpWaterHEIFAscore;
            _tmpWaterHEIFAscore = _cursor.getDouble(_cursorIndexOfWaterHEIFAscore);
            final double _tmpWater;
            _tmpWater = _cursor.getDouble(_cursorIndexOfWater);
            final double _tmpWaterTotalmL;
            _tmpWaterTotalmL = _cursor.getDouble(_cursorIndexOfWaterTotalmL);
            final double _tmpBeverageTotalmL;
            _tmpBeverageTotalmL = _cursor.getDouble(_cursorIndexOfBeverageTotalmL);
            final double _tmpSugarHEIFAscore;
            _tmpSugarHEIFAscore = _cursor.getDouble(_cursorIndexOfSugarHEIFAscore);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSaturatedFatHEIFAscore;
            _tmpSaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfSaturatedFatHEIFAscore);
            final double _tmpSaturatedFat;
            _tmpSaturatedFat = _cursor.getDouble(_cursorIndexOfSaturatedFat);
            final double _tmpUnsaturatedFatHEIFAscore;
            _tmpUnsaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfUnsaturatedFatHEIFAscore);
            final double _tmpUnsaturatedFatservesize;
            _tmpUnsaturatedFatservesize = _cursor.getDouble(_cursorIndexOfUnsaturatedFatservesize);
            final boolean _tmpQuestionnaire;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfQuestionnaire);
            _tmpQuestionnaire = _tmp != 0;
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new User(_tmpId,_tmpPhoneNumber,_tmpSex,_tmpHEIFAtotalscore,_tmpDiscretionaryHEIFAscore,_tmpDiscretionaryservesize,_tmpVegetablesHEIFAscore,_tmpVegetableswithlegumesallocatedservesize,_tmpLegumesallocatedVegetables,_tmpVegetablesvariationsscore,_tmpVegetablesCruciferous,_tmpVegetablesTuberandbulb,_tmpVegetablesOther,_tmpLegumes,_tmpVegetablesGreen,_tmpVegetablesRedandorange,_tmpFruitHEIFAscore,_tmpFruitserversize,_tmpFruitvariationsscore,_tmpFruitPome,_tmpFruitTropicalandsubtropical,_tmpFruitBerry,_tmpFruitStone,_tmpFruitCitrus,_tmpFruitOther,_tmpGrainsandcerealsHEIFAscore,_tmpGrainsandcerealsservesize,_tmpGrainsandcerealsNonwholegrains,_tmpWholegrainsHEIFAscore,_tmpWholegrainsservesize,_tmpMeatandalternativesHEIFAscore,_tmpMeatandalternativeswithlegumesallocatedservesize,_tmpLegumesallocatedMeatandalternatives,_tmpDairyandalternativesHEIFAscore,_tmpDairyandalternativesservesize,_tmpSodiumHEIFAscore,_tmpSodiummgmilligrams,_tmpAlcoholHEIFAscore,_tmpAlcoholstandarddrinks,_tmpWaterHEIFAscore,_tmpWater,_tmpWaterTotalmL,_tmpBeverageTotalmL,_tmpSugarHEIFAscore,_tmpSugar,_tmpSaturatedFatHEIFAscore,_tmpSaturatedFat,_tmpUnsaturatedFatHEIFAscore,_tmpUnsaturatedFatservesize,_tmpQuestionnaire,_tmpPassword);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllUsersOnce(final Continuation<? super List<User>> $completion) {
    final String _sql = "SELECT * FROM user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<User>>() {
      @Override
      @NonNull
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
          final int _cursorIndexOfHEIFAtotalscore = CursorUtil.getColumnIndexOrThrow(_cursor, "HEIFAtotalscore");
          final int _cursorIndexOfDiscretionaryHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DiscretionaryHEIFAscore");
          final int _cursorIndexOfDiscretionaryservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Discretionaryservesize");
          final int _cursorIndexOfVegetablesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesHEIFAscore");
          final int _cursorIndexOfVegetableswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetableswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedVegetables = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedVegetables");
          final int _cursorIndexOfVegetablesvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Vegetablesvariationsscore");
          final int _cursorIndexOfVegetablesCruciferous = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesCruciferous");
          final int _cursorIndexOfVegetablesTuberandbulb = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesTuberandbulb");
          final int _cursorIndexOfVegetablesOther = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesOther");
          final int _cursorIndexOfLegumes = CursorUtil.getColumnIndexOrThrow(_cursor, "Legumes");
          final int _cursorIndexOfVegetablesGreen = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesGreen");
          final int _cursorIndexOfVegetablesRedandorange = CursorUtil.getColumnIndexOrThrow(_cursor, "VegetablesRedandorange");
          final int _cursorIndexOfFruitHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitHEIFAscore");
          final int _cursorIndexOfFruitserversize = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitserversize");
          final int _cursorIndexOfFruitvariationsscore = CursorUtil.getColumnIndexOrThrow(_cursor, "Fruitvariationsscore");
          final int _cursorIndexOfFruitPome = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitPome");
          final int _cursorIndexOfFruitTropicalandsubtropical = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitTropicalandsubtropical");
          final int _cursorIndexOfFruitBerry = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitBerry");
          final int _cursorIndexOfFruitStone = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitStone");
          final int _cursorIndexOfFruitCitrus = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitCitrus");
          final int _cursorIndexOfFruitOther = CursorUtil.getColumnIndexOrThrow(_cursor, "FruitOther");
          final int _cursorIndexOfGrainsandcerealsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsHEIFAscore");
          final int _cursorIndexOfGrainsandcerealsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Grainsandcerealsservesize");
          final int _cursorIndexOfGrainsandcerealsNonwholegrains = CursorUtil.getColumnIndexOrThrow(_cursor, "GrainsandcerealsNonwholegrains");
          final int _cursorIndexOfWholegrainsHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WholegrainsHEIFAscore");
          final int _cursorIndexOfWholegrainsservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Wholegrainsservesize");
          final int _cursorIndexOfMeatandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "MeatandalternativesHEIFAscore");
          final int _cursorIndexOfMeatandalternativeswithlegumesallocatedservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Meatandalternativeswithlegumesallocatedservesize");
          final int _cursorIndexOfLegumesallocatedMeatandalternatives = CursorUtil.getColumnIndexOrThrow(_cursor, "LegumesallocatedMeatandalternatives");
          final int _cursorIndexOfDairyandalternativesHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "DairyandalternativesHEIFAscore");
          final int _cursorIndexOfDairyandalternativesservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "Dairyandalternativesservesize");
          final int _cursorIndexOfSodiumHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SodiumHEIFAscore");
          final int _cursorIndexOfSodiummgmilligrams = CursorUtil.getColumnIndexOrThrow(_cursor, "Sodiummgmilligrams");
          final int _cursorIndexOfAlcoholHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "AlcoholHEIFAscore");
          final int _cursorIndexOfAlcoholstandarddrinks = CursorUtil.getColumnIndexOrThrow(_cursor, "Alcoholstandarddrinks");
          final int _cursorIndexOfWaterHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterHEIFAscore");
          final int _cursorIndexOfWater = CursorUtil.getColumnIndexOrThrow(_cursor, "Water");
          final int _cursorIndexOfWaterTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "WaterTotalmL");
          final int _cursorIndexOfBeverageTotalmL = CursorUtil.getColumnIndexOrThrow(_cursor, "BeverageTotalmL");
          final int _cursorIndexOfSugarHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SugarHEIFAscore");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "Sugar");
          final int _cursorIndexOfSaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFatHEIFAscore");
          final int _cursorIndexOfSaturatedFat = CursorUtil.getColumnIndexOrThrow(_cursor, "SaturatedFat");
          final int _cursorIndexOfUnsaturatedFatHEIFAscore = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatHEIFAscore");
          final int _cursorIndexOfUnsaturatedFatservesize = CursorUtil.getColumnIndexOrThrow(_cursor, "UnsaturatedFatservesize");
          final int _cursorIndexOfQuestionnaire = CursorUtil.getColumnIndexOrThrow(_cursor, "questionnaire");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final User _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPhoneNumber;
            _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            final String _tmpSex;
            _tmpSex = _cursor.getString(_cursorIndexOfSex);
            final double _tmpHEIFAtotalscore;
            _tmpHEIFAtotalscore = _cursor.getDouble(_cursorIndexOfHEIFAtotalscore);
            final double _tmpDiscretionaryHEIFAscore;
            _tmpDiscretionaryHEIFAscore = _cursor.getDouble(_cursorIndexOfDiscretionaryHEIFAscore);
            final double _tmpDiscretionaryservesize;
            _tmpDiscretionaryservesize = _cursor.getDouble(_cursorIndexOfDiscretionaryservesize);
            final double _tmpVegetablesHEIFAscore;
            _tmpVegetablesHEIFAscore = _cursor.getDouble(_cursorIndexOfVegetablesHEIFAscore);
            final double _tmpVegetableswithlegumesallocatedservesize;
            _tmpVegetableswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfVegetableswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedVegetables;
            _tmpLegumesallocatedVegetables = _cursor.getDouble(_cursorIndexOfLegumesallocatedVegetables);
            final double _tmpVegetablesvariationsscore;
            _tmpVegetablesvariationsscore = _cursor.getDouble(_cursorIndexOfVegetablesvariationsscore);
            final double _tmpVegetablesCruciferous;
            _tmpVegetablesCruciferous = _cursor.getDouble(_cursorIndexOfVegetablesCruciferous);
            final double _tmpVegetablesTuberandbulb;
            _tmpVegetablesTuberandbulb = _cursor.getDouble(_cursorIndexOfVegetablesTuberandbulb);
            final double _tmpVegetablesOther;
            _tmpVegetablesOther = _cursor.getDouble(_cursorIndexOfVegetablesOther);
            final double _tmpLegumes;
            _tmpLegumes = _cursor.getDouble(_cursorIndexOfLegumes);
            final double _tmpVegetablesGreen;
            _tmpVegetablesGreen = _cursor.getDouble(_cursorIndexOfVegetablesGreen);
            final double _tmpVegetablesRedandorange;
            _tmpVegetablesRedandorange = _cursor.getDouble(_cursorIndexOfVegetablesRedandorange);
            final double _tmpFruitHEIFAscore;
            _tmpFruitHEIFAscore = _cursor.getDouble(_cursorIndexOfFruitHEIFAscore);
            final double _tmpFruitserversize;
            _tmpFruitserversize = _cursor.getDouble(_cursorIndexOfFruitserversize);
            final double _tmpFruitvariationsscore;
            _tmpFruitvariationsscore = _cursor.getDouble(_cursorIndexOfFruitvariationsscore);
            final double _tmpFruitPome;
            _tmpFruitPome = _cursor.getDouble(_cursorIndexOfFruitPome);
            final double _tmpFruitTropicalandsubtropical;
            _tmpFruitTropicalandsubtropical = _cursor.getDouble(_cursorIndexOfFruitTropicalandsubtropical);
            final double _tmpFruitBerry;
            _tmpFruitBerry = _cursor.getDouble(_cursorIndexOfFruitBerry);
            final double _tmpFruitStone;
            _tmpFruitStone = _cursor.getDouble(_cursorIndexOfFruitStone);
            final double _tmpFruitCitrus;
            _tmpFruitCitrus = _cursor.getDouble(_cursorIndexOfFruitCitrus);
            final double _tmpFruitOther;
            _tmpFruitOther = _cursor.getDouble(_cursorIndexOfFruitOther);
            final double _tmpGrainsandcerealsHEIFAscore;
            _tmpGrainsandcerealsHEIFAscore = _cursor.getDouble(_cursorIndexOfGrainsandcerealsHEIFAscore);
            final double _tmpGrainsandcerealsservesize;
            _tmpGrainsandcerealsservesize = _cursor.getDouble(_cursorIndexOfGrainsandcerealsservesize);
            final double _tmpGrainsandcerealsNonwholegrains;
            _tmpGrainsandcerealsNonwholegrains = _cursor.getDouble(_cursorIndexOfGrainsandcerealsNonwholegrains);
            final double _tmpWholegrainsHEIFAscore;
            _tmpWholegrainsHEIFAscore = _cursor.getDouble(_cursorIndexOfWholegrainsHEIFAscore);
            final double _tmpWholegrainsservesize;
            _tmpWholegrainsservesize = _cursor.getDouble(_cursorIndexOfWholegrainsservesize);
            final double _tmpMeatandalternativesHEIFAscore;
            _tmpMeatandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfMeatandalternativesHEIFAscore);
            final double _tmpMeatandalternativeswithlegumesallocatedservesize;
            _tmpMeatandalternativeswithlegumesallocatedservesize = _cursor.getDouble(_cursorIndexOfMeatandalternativeswithlegumesallocatedservesize);
            final double _tmpLegumesallocatedMeatandalternatives;
            _tmpLegumesallocatedMeatandalternatives = _cursor.getDouble(_cursorIndexOfLegumesallocatedMeatandalternatives);
            final double _tmpDairyandalternativesHEIFAscore;
            _tmpDairyandalternativesHEIFAscore = _cursor.getDouble(_cursorIndexOfDairyandalternativesHEIFAscore);
            final double _tmpDairyandalternativesservesize;
            _tmpDairyandalternativesservesize = _cursor.getDouble(_cursorIndexOfDairyandalternativesservesize);
            final double _tmpSodiumHEIFAscore;
            _tmpSodiumHEIFAscore = _cursor.getDouble(_cursorIndexOfSodiumHEIFAscore);
            final double _tmpSodiummgmilligrams;
            _tmpSodiummgmilligrams = _cursor.getDouble(_cursorIndexOfSodiummgmilligrams);
            final double _tmpAlcoholHEIFAscore;
            _tmpAlcoholHEIFAscore = _cursor.getDouble(_cursorIndexOfAlcoholHEIFAscore);
            final double _tmpAlcoholstandarddrinks;
            _tmpAlcoholstandarddrinks = _cursor.getDouble(_cursorIndexOfAlcoholstandarddrinks);
            final double _tmpWaterHEIFAscore;
            _tmpWaterHEIFAscore = _cursor.getDouble(_cursorIndexOfWaterHEIFAscore);
            final double _tmpWater;
            _tmpWater = _cursor.getDouble(_cursorIndexOfWater);
            final double _tmpWaterTotalmL;
            _tmpWaterTotalmL = _cursor.getDouble(_cursorIndexOfWaterTotalmL);
            final double _tmpBeverageTotalmL;
            _tmpBeverageTotalmL = _cursor.getDouble(_cursorIndexOfBeverageTotalmL);
            final double _tmpSugarHEIFAscore;
            _tmpSugarHEIFAscore = _cursor.getDouble(_cursorIndexOfSugarHEIFAscore);
            final double _tmpSugar;
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            final double _tmpSaturatedFatHEIFAscore;
            _tmpSaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfSaturatedFatHEIFAscore);
            final double _tmpSaturatedFat;
            _tmpSaturatedFat = _cursor.getDouble(_cursorIndexOfSaturatedFat);
            final double _tmpUnsaturatedFatHEIFAscore;
            _tmpUnsaturatedFatHEIFAscore = _cursor.getDouble(_cursorIndexOfUnsaturatedFatHEIFAscore);
            final double _tmpUnsaturatedFatservesize;
            _tmpUnsaturatedFatservesize = _cursor.getDouble(_cursorIndexOfUnsaturatedFatservesize);
            final boolean _tmpQuestionnaire;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfQuestionnaire);
            _tmpQuestionnaire = _tmp != 0;
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _item = new User(_tmpId,_tmpPhoneNumber,_tmpSex,_tmpHEIFAtotalscore,_tmpDiscretionaryHEIFAscore,_tmpDiscretionaryservesize,_tmpVegetablesHEIFAscore,_tmpVegetableswithlegumesallocatedservesize,_tmpLegumesallocatedVegetables,_tmpVegetablesvariationsscore,_tmpVegetablesCruciferous,_tmpVegetablesTuberandbulb,_tmpVegetablesOther,_tmpLegumes,_tmpVegetablesGreen,_tmpVegetablesRedandorange,_tmpFruitHEIFAscore,_tmpFruitserversize,_tmpFruitvariationsscore,_tmpFruitPome,_tmpFruitTropicalandsubtropical,_tmpFruitBerry,_tmpFruitStone,_tmpFruitCitrus,_tmpFruitOther,_tmpGrainsandcerealsHEIFAscore,_tmpGrainsandcerealsservesize,_tmpGrainsandcerealsNonwholegrains,_tmpWholegrainsHEIFAscore,_tmpWholegrainsservesize,_tmpMeatandalternativesHEIFAscore,_tmpMeatandalternativeswithlegumesallocatedservesize,_tmpLegumesallocatedMeatandalternatives,_tmpDairyandalternativesHEIFAscore,_tmpDairyandalternativesservesize,_tmpSodiumHEIFAscore,_tmpSodiummgmilligrams,_tmpAlcoholHEIFAscore,_tmpAlcoholstandarddrinks,_tmpWaterHEIFAscore,_tmpWater,_tmpWaterTotalmL,_tmpBeverageTotalmL,_tmpSugarHEIFAscore,_tmpSugar,_tmpSaturatedFatHEIFAscore,_tmpSaturatedFat,_tmpUnsaturatedFatHEIFAscore,_tmpUnsaturatedFatservesize,_tmpQuestionnaire,_tmpPassword);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMaleAverageScore(final Continuation<? super Double> $completion) {
    final String _sql = "SELECT AVG(HEIFAtotalscore) AS average_score FROM user WHERE sex = 'Male'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @NonNull
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final double _tmp;
            _tmp = _cursor.getDouble(0);
            _result = _tmp;
          } else {
            _result = 0.0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getFemaleAverageScore(final Continuation<? super Double> $completion) {
    final String _sql = "SELECT AVG(HEIFAtotalscore) AS average_score FROM user WHERE sex = 'Female'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @NonNull
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final double _tmp;
            _tmp = _cursor.getDouble(0);
            _result = _tmp;
          } else {
            _result = 0.0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
