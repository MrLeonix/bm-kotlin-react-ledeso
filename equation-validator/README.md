# Equation Validator

## Summary

Because of the problems mentioned below, a new project folder has been created named as `equation-validator-alt`.

Not having the ability to take advantage from Kotlin Native (and using some of the existing code) made me write the
implementation twice (Kotlin and JS), rather than having a single place exporting the JS lib.

On the other hand, we got to test it twice! :)

## Problems

Unfortunately, I couldn't make Kotlin Native to work on a Mac M1.

I kept getting an error not being able to find Xcode installed, although it is installed.

I searched the web for an hour and couldn't find anything that would solve the issue, since the majority
of solutions would require to download Xcode, which I couldn't because Xcode requires MacOS version 12.5 and
the one I'm using is at v12.4, with no updates available for the next version.

`gradlew build` error stack trace:
```
% ./gradlew build

> Configure project :
Kotlin Multiplatform Projects are an Alpha feature. See: https://kotlinlang.org/docs/reference/evolution/components-stability.html. To hide this message, add 'kotlin.mpp.stability.nowarn=true' to the Gradle properties.

The property 'kotlin.mpp.enableGranularSourceSetsMetadata=true' has no effect in this and future Kotlin versions, as Hierarchical Structures support is now enabled by default. It is safe to remove the property.

The property 'kotlin.native.enableDependencyPropagation=false' has no effect in this and future Kotlin versions, as Kotlin/Native dependency commonization is now enabled by default. It is safe to remove the property.


> Task :compileKotlinNative FAILED
e: Compilation failed: An error occurred during an xcrun execution. Make sure that Xcode and its command line tools are properly installed.
Failed command: /usr/bin/xcrun xcodebuild -version
Try running this command in Terminal and fix the errors by making Xcode (and its command line tools) configuration correct.

 * Source files: Validator.kt, main.kt
 * Compiler version info: Konan: 1.7.10 / Kotlin: 1.7.20
 * Output kind: LIBRARY

e: org.jetbrains.kotlin.konan.MissingXcodeException: An error occurred during an xcrun execution. Make sure that Xcode and its command line tools are properly installed.
Failed command: /usr/bin/xcrun xcodebuild -version
Try running this command in Terminal and fix the errors by making Xcode (and its command line tools) configuration correct.
        at org.jetbrains.kotlin.konan.target.CurrentXcode.xcrun(Xcode.kt:107)
        at org.jetbrains.kotlin.konan.target.CurrentXcode.access$xcrun(Xcode.kt:67)
        at org.jetbrains.kotlin.konan.target.CurrentXcode$version$2.invoke(Xcode.kt:92)
        at org.jetbrains.kotlin.konan.target.CurrentXcode$version$2.invoke(Xcode.kt:91)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at org.jetbrains.kotlin.konan.target.CurrentXcode.getVersion(Xcode.kt:91)
        at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl$xcodePartsProvider$2.invoke(Apple.kt:62)
        at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl$xcodePartsProvider$2.invoke(Apple.kt:54)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl.getXcodePartsProvider(Apple.kt:54)
        at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl.getDependencies(Apple.kt:49)
        at org.jetbrains.kotlin.konan.util.DependencyProcessor.<init>(DependencyProcessor.kt:125)
        at org.jetbrains.kotlin.konan.util.DependencyProcessor.<init>(DependencyProcessor.kt:117)
        at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader$dependencyProcessor$2.invoke(KonanProperties.kt:91)
        at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader$dependencyProcessor$2.invoke(KonanProperties.kt:89)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader.getDependencyProcessor(KonanProperties.kt:89)
        at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader.downloadDependencies(KonanProperties.kt:70)
        at org.jetbrains.kotlin.konan.target.Platform.downloadDependencies(Platform.kt)
        at org.jetbrains.kotlin.backend.konan.KonanConfig.<init>(KonanConfig.kt:148)
        at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:91)
        at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:37)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:94)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:43)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:79)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:43)
        at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit(CLITool.kt:179)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion$mainNoExitWithGradleRenderer$1.invoke(K2Native.kt:423)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion$mainNoExitWithGradleRenderer$1.invoke(K2Native.kt:422)
        at org.jetbrains.kotlin.util.UtilKt.profileIf(Util.kt:22)
        at org.jetbrains.kotlin.util.UtilKt.profile(Util.kt:16)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion.mainNoExitWithGradleRenderer(K2Native.kt:422)
        at org.jetbrains.kotlin.cli.bc.K2NativeKt.mainNoExitWithGradleRenderer(K2Native.kt:677)
        at org.jetbrains.kotlin.cli.utilities.MainKt$daemonMain$1$1.invoke(main.kt:70)
        at org.jetbrains.kotlin.cli.utilities.MainKt$daemonMain$1$1.invoke(main.kt:70)
        at org.jetbrains.kotlin.cli.utilities.MainKt.mainImpl(main.kt:19)
        at org.jetbrains.kotlin.cli.utilities.MainKt.daemonMain(main.kt:70)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.jetbrains.kotlin.compilerRunner.KotlinToolRunner.runInProcess(KotlinToolRunner.kt:136)
        at org.jetbrains.kotlin.compilerRunner.KotlinToolRunner.run(KotlinToolRunner.kt:81)
        at org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile.compile(KotlinNativeTasks.kt:458)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:104)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.doExecute(StandardTaskAction.java:58)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:51)
        at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:29)
        at org.gradle.api.internal.tasks.execution.TaskExecution$2.run(TaskExecution.java:239)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:29)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:26)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.run(DefaultBuildOperationRunner.java:47)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:68)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeAction(TaskExecution.java:224)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeActions(TaskExecution.java:207)
        at org.gradle.api.internal.tasks.execution.TaskExecution.executeWithPreviousOutputFiles(TaskExecution.java:190)
        at org.gradle.api.internal.tasks.execution.TaskExecution.execute(TaskExecution.java:168)
        at org.gradle.internal.execution.steps.ExecuteStep.executeInternal(ExecuteStep.java:89)
        at org.gradle.internal.execution.steps.ExecuteStep.access$000(ExecuteStep.java:40)
        at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:53)
        at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:50)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
        at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:50)
        at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:40)
        at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.execute(RemovePreviousOutputsStep.java:68)
        at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.execute(RemovePreviousOutputsStep.java:38)
        at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:48)
        at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:36)
        at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:41)
        at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:74)
        at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:55)
        at org.gradle.internal.execution.steps.CreateOutputsStep.execute(CreateOutputsStep.java:51)
        at org.gradle.internal.execution.steps.CreateOutputsStep.execute(CreateOutputsStep.java:29)
        at org.gradle.internal.execution.steps.CaptureStateAfterExecutionStep.execute(CaptureStateAfterExecutionStep.java:61)
        at org.gradle.internal.execution.steps.CaptureStateAfterExecutionStep.execute(CaptureStateAfterExecutionStep.java:42)
        at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:60)
        at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:27)
        at org.gradle.internal.execution.steps.BuildCacheStep.executeWithoutCache(BuildCacheStep.java:188)
        at org.gradle.internal.execution.steps.BuildCacheStep.lambda$execute$1(BuildCacheStep.java:75)
        at org.gradle.internal.Either$Right.fold(Either.java:175)
        at org.gradle.internal.execution.caching.CachingState.fold(CachingState.java:59)
        at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:73)
        at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:48)
        at org.gradle.internal.execution.steps.StoreExecutionStateStep.execute(StoreExecutionStateStep.java:38)
        at org.gradle.internal.execution.steps.StoreExecutionStateStep.execute(StoreExecutionStateStep.java:27)
        at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:36)
        at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:22)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:109)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$2(SkipUpToDateStep.java:56)
        at java.base/java.util.Optional.orElseGet(Optional.java:364)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:56)
        at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:38)
        at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:73)
        at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:44)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:37)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:27)
        at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:89)
        at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:50)
        at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:114)
        at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:57)
        at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:76)
        at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:50)
        at org.gradle.internal.execution.steps.SkipEmptyWorkStep.lambda$execute$2(SkipEmptyWorkStep.java:93)
        at java.base/java.util.Optional.orElseGet(Optional.java:364)
        at org.gradle.internal.execution.steps.SkipEmptyWorkStep.execute(SkipEmptyWorkStep.java:93)
        at org.gradle.internal.execution.steps.SkipEmptyWorkStep.execute(SkipEmptyWorkStep.java:34)
        at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsStartedStep.execute(MarkSnapshottingInputsStartedStep.java:38)
        at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.execute(LoadPreviousExecutionStateStep.java:43)
        at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.execute(LoadPreviousExecutionStateStep.java:31)
        at org.gradle.internal.execution.steps.AssignWorkspaceStep.lambda$execute$0(AssignWorkspaceStep.java:40)
        at org.gradle.api.internal.tasks.execution.TaskExecution$3.withWorkspace(TaskExecution.java:284)
        at org.gradle.internal.execution.steps.AssignWorkspaceStep.execute(AssignWorkspaceStep.java:40)
        at org.gradle.internal.execution.steps.AssignWorkspaceStep.execute(AssignWorkspaceStep.java:30)
        at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:37)
        at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:27)
        at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:44)
        at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:33)
        at org.gradle.internal.execution.impl.DefaultExecutionEngine$1.execute(DefaultExecutionEngine.java:76)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:142)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:131)
        at org.gradle.api.internal.tasks.execution.CleanupStaleOutputsExecuter.execute(CleanupStaleOutputsExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
        at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
        at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
        at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:56)
        at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
        at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:74)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:402)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:389)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:382)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:368)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.lambda$run$0(DefaultPlanExecutor.java:127)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:191)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.executeNextNode(DefaultPlanExecutor.java:182)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:124)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:61)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: org.jetbrains.kotlin.konan.KonanExternalToolFailure: The /usr/bin/xcrun command returned non-zero exit code: 72.
output:

        at org.jetbrains.kotlin.konan.exec.Command.handleExitCode(ExecuteCommand.kt:114)
        at org.jetbrains.kotlin.konan.exec.Command.getResult(ExecuteCommand.kt:103)
        at org.jetbrains.kotlin.konan.exec.Command.getOutputLines(ExecuteCommand.kt:82)
        at org.jetbrains.kotlin.konan.exec.Command.getOutputLines$default(ExecuteCommand.kt:81)
        at org.jetbrains.kotlin.konan.target.CurrentXcode.xcrun(Xcode.kt:97)
        ... 168 more


FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileKotlinNative'.
> Compilation finished with errors

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

See https://docs.gradle.org/7.3.3/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 791ms
5 actionable tasks: 2 executed, 3 up-to-date
```
