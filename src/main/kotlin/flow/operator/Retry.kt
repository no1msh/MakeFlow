package flow.operator

import flow.builder.Flow


fun <T> Flow<T>.retry(
    retries: Long = Long.MAX_VALUE,
    predicate: suspend (cause: Throwable) -> Boolean = { true }
): Flow<T> {
    require(retries > 0) { "retries는 양수여야 합니다. $retries" }
    return retryWhen { cause, attempt -> attempt < retries && predicate(cause) }
}
