package com.jason798.hbase.antlr.core;

import com.jason798.hbase.api.HBaseException;
import org.antlr.v4.runtime.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlParseErrorHandler
 *
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class SqlParseErrorHandler extends DefaultErrorStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlParseErrorHandler.class);
    public static final SqlParseErrorHandler instance = new SqlParseErrorHandler();

    /**
     * Instead of recovering from exception e, rethrow it wrapped in a generic
     * RuntimeException so it is not caught by the rule function catches.
     * Exception e is the "cause" of the RuntimeException.
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        LOGGER.error(e.getMessage());
        throw new HBaseException(e);
    }

    /**
     * Make sure we don't attempt to recover inline; if the parser successfully
     * recovers, it won't throw an exception.
     */
    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        LOGGER.error("parser error.");
        throw new HBaseException("parser error.", new InputMismatchException(recognizer));
    }

    /**
     * Make sure we don't attempt to recover from problems in subrules.
     **/
    @Override
    public void sync(Parser recognizer) {
    }

    private SqlParseErrorHandler() {
    }

}
