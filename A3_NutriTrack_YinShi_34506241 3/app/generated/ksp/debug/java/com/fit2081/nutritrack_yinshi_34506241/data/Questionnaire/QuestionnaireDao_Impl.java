package com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionnaireDao_Impl implements QuestionnaireDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuestionnaireAnswers> __insertionAdapterOfQuestionnaireAnswers;

  private final EntityDeletionOrUpdateAdapter<QuestionnaireAnswers> __deletionAdapterOfQuestionnaireAnswers;

  private final EntityDeletionOrUpdateAdapter<QuestionnaireAnswers> __updateAdapterOfQuestionnaireAnswers;

  public QuestionnaireDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestionnaireAnswers = new EntityInsertionAdapter<QuestionnaireAnswers>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `food_questionnaire` (`questionnaireId`,`firstPartResult`,`thirdPartResult`,`fourthPartResult`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QuestionnaireAnswers entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getFirstPartResult());
        statement.bindString(3, entity.getThirdPartResult());
        statement.bindString(4, entity.getFourthPartResult());
      }
    };
    this.__deletionAdapterOfQuestionnaireAnswers = new EntityDeletionOrUpdateAdapter<QuestionnaireAnswers>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `food_questionnaire` WHERE `questionnaireId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QuestionnaireAnswers entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__updateAdapterOfQuestionnaireAnswers = new EntityDeletionOrUpdateAdapter<QuestionnaireAnswers>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `food_questionnaire` SET `questionnaireId` = ?,`firstPartResult` = ?,`thirdPartResult` = ?,`fourthPartResult` = ? WHERE `questionnaireId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final QuestionnaireAnswers entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getFirstPartResult());
        statement.bindString(3, entity.getThirdPartResult());
        statement.bindString(4, entity.getFourthPartResult());
        statement.bindString(5, entity.getId());
      }
    };
  }

  @Override
  public Object insertQuestionnaire(final QuestionnaireAnswers questionnaire,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfQuestionnaireAnswers.insert(questionnaire);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteQuestionnaire(final QuestionnaireAnswers questionnaire,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfQuestionnaireAnswers.handle(questionnaire);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateQuestionnaire(final QuestionnaireAnswers questionnaire,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfQuestionnaireAnswers.handle(questionnaire);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getQuestionnaireById(final String id,
      final Continuation<? super QuestionnaireAnswers> $completion) {
    final String _sql = "SELECT * FROM food_questionnaire WHERE questionnaireId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<QuestionnaireAnswers>() {
      @Override
      @Nullable
      public QuestionnaireAnswers call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "questionnaireId");
          final int _cursorIndexOfFirstPartResult = CursorUtil.getColumnIndexOrThrow(_cursor, "firstPartResult");
          final int _cursorIndexOfThirdPartResult = CursorUtil.getColumnIndexOrThrow(_cursor, "thirdPartResult");
          final int _cursorIndexOfFourthPartResult = CursorUtil.getColumnIndexOrThrow(_cursor, "fourthPartResult");
          final QuestionnaireAnswers _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpFirstPartResult;
            _tmpFirstPartResult = _cursor.getString(_cursorIndexOfFirstPartResult);
            final String _tmpThirdPartResult;
            _tmpThirdPartResult = _cursor.getString(_cursorIndexOfThirdPartResult);
            final String _tmpFourthPartResult;
            _tmpFourthPartResult = _cursor.getString(_cursorIndexOfFourthPartResult);
            _result = new QuestionnaireAnswers(_tmpId,_tmpFirstPartResult,_tmpThirdPartResult,_tmpFourthPartResult);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
