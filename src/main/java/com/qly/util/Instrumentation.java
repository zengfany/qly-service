package com.qly.util;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

/**
 * Created by Fanyi on 15/10/2.
 */
public class Instrumentation {
    public static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();


    // Timers

    public static final Timer GDM_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry.name("GDM Call Time"));

    public static final Timer MSWS_SEARCH_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("MSWS Serarch Time"));

    public static final Timer FORCE_SEARCH_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Force Search Time"));

    public static final Timer XOBNI_TOP_CONTACTS_FETCH_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Xobni Top Contacts Fetch Time"));

    public static final Timer XOBNI_SEARCH_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Xobni Contact Search Time"));

    public static final Timer PACHYDERM_SEARCH_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Pachyderm Search Time"));

    // Error counters

    public static final Meter GDM_CALL_ERROR = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("GDM Call Errors"));

    public static final Meter MSWS_CALL_ERROR = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("MSWS Call Errors"));

    public static final Meter FORCE_CALL_ERROR = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Force Call Errors"));

    public static final Meter XOBNI_CALL_ERROR = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Xobni Call Errors"));

    public static final Meter PACHYDERM_CALL_ERROR = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Pachyderm Call Errors"));

    // Suggestion Pipeline Counters and Timers

    public static final Timer PARSER_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry.name("Parser Time"));

    public static final Timer timeTillSuggestionsComplete = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Suggestions Completion Time"));

    // Content Pipeline Counters and Timers

    public static final Meter ITEMS_CALL_COUNTER = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Number of Item Calls"));

    public static final Meter SRP_CALL_COUNTER = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Number of Srp Calls"));

    public static final Meter BATCH_CALL_COUNTER = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Number of Batch Calls"));

    public static final Meter INTERNAL_ERROR_COUNTER = Instrumentation.METRIC_REGISTRY.meter(MetricRegistry
            .name("Unhandled Internal Errors (Fix this Immediately)"));

    public static final Timer SRP_CALL_COMPLETION_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Srp Call Completion Time"));

    public static final Timer BATCH_CALL_COMPLETION_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Batch Call Completion Time"));

    public static final Timer ITEMS_CALL_COMPLETION_TIME = Instrumentation.METRIC_REGISTRY.timer(MetricRegistry
            .name("Items Call Completion Time"));


}
