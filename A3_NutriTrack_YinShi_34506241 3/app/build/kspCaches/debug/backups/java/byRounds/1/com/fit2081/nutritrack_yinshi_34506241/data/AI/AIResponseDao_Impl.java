package com.fit2081.nutritrack_yinshi_34506241.data.AI;

import android.database.Cursor;
import androidx.annotation.NonNull;
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
public final class AIResponseDao_Impl implements AIResponseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AIResponse> __insertionAdapterOfAIResponse;

  private final EntityDeletionOrUpdateAdapter<AIResponse> __deletionAdapterOfAIResponse;

  public AIResponseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAIResponse = new EntityInsertionAdapter<AIResponse>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ai_response` (`id`,`userId`,`promptTips`,`promptFeedback`,`tip`,`feedback`,`dateTime`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AIResponse entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getUserId());
        statement.bindString(3, entity.getPromptTips());
        statement.bindString(4, entity.getPromptFeedback());
        statement.bindString(5, entity.getTip());
        statement.bindString(6, entity.getFeedback());
        statement.bindString(7, entity.getDateTime());
      }
    };
    this.__deletionAdapterOfAIResponse = new EntityDeletionOrUpdateAdapter<AIResponse>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `ai_response` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AIResponse entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertAIResponse(final AIResponse aiResponse,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAIResponse.insert(aiResponse);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAIResponse(final AIResponse aiResponse,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAIResponse.handle(aiResponse);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AIResponse>> getAIResponsesOrderDateTime(final String userId) {
    final String _sql = "SELECT * FROM ai_response WHERE userId = ? ORDER BY dateTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, userId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ai_response"}, new Callable<List<AIResponse>>() {
      @Override
      @NonNull
      public List<AIResponse> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfPromptTips = CursorUtil.getColumnIndexOrThrow(_cursor, "promptTips");
          final int _cursorIndexOfPromptFeedback = CursorUtil.getColumnIndexOrThrow(_cursor, "promptFeedback");
          final int _cursorIndexOfTip = CursorUtil.getColumnIndexOrThrow(_cursor, "tip");
          final int _cursorIndexOfFeedback = CursorUtil.getColumnIndexOrThrow(_cursor, "feedback");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final List<AIResponse> _result = new ArrayList<AIResponse>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AIResponse _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpPromptTips;
            _tmpPromptTips = _cursor.getString(_cursorIndexOfPromptTips);
            final String _tmpPromptFeedback;
            _tmpPromptFeedback = _cursor.getString(_cursorIndexOfPromptFeedback);
            final String _tmpTip;
            _tmpTip = _cursor.getString(_cursorIndexOfTip);
            final String _tmpFeedback;
            _tmpFeedback = _cursor.getString(_cursorIndexOfFeedback);
            final String _tmpDateTime;
            _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            _item = new AIResponse(_tmpId,_tmpUserId,_tmpPromptTips,_tmpPromptFeedback,_tmpTip,_tmpFeedback,_tmpDateTime);
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
  public Flow<List<AIResponse>> getAIResponsesOrderId(final String userId) {
    final String _sql = "SELECT * FROM ai_response WHERE userId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, userId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ai_response"}, new Callable<List<AIResponse>>() {
      @Override
      @NonNull
      public List<AIResponse> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfPromptTips = CursorUtil.getColumnIndexOrThrow(_cursor, "promptTips");
          final int _cursorIndexOfPromptFeedback = CursorUtil.getColumnIndexOrThrow(_cursor, "promptFeedback");
          final int _cursorIndexOfTip = CursorUtil.getColumnIndexOrThrow(_cursor, "tip");
          final int _cursorIndexOfFeedback = CursorUtil.getColumnIndexOrThrow(_cursor, "feedback");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dateTime");
          final List<AIResponse> _result = new ArrayList<AIResponse>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AIResponse _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpPromptTips;
            _tmpPromptTips = _cursor.getString(_cursorIndexOfPromptTips);
            final String _tmpPromptFeedback;
            _tmpPromptFeedback = _cursor.getString(_cursorIndexOfPromptFeedback);
            final String _tmpTip;
            _tmpTip = _cursor.getString(_cursorIndexOfTip);
            final String _tmpFeedback;
            _tmpFeedback = _cursor.getString(_cursorIndexOfFeedback);
            final String _tmpDateTime;
            _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            _item = new AIResponse(_tmpId,_tmpUserId,_tmpPromptTips,_tmpPromptFeedback,_tmpTip,_tmpFeedback,_tmpDateTime);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
