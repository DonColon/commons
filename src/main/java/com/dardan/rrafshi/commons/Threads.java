package com.dardan.rrafshi.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;


public final class Threads
{
	private Threads() {}


	public static void safeSleep(final TimeUnit timeUnit, final long duration)
	{
		safeSleep(timeUnit.toMillis(duration));
	}

	public static void safeSleep(final long durationInMilliseconds)
	{
		try {
			Thread.sleep(durationInMilliseconds);

		} catch (final InterruptedException exception) {

			Thread.currentThread().interrupt();
		}
	}


	public static ThreadGroup getRootGroup()
	{
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();

		for(ThreadGroup parentGroup = rootGroup; parentGroup != null; parentGroup = parentGroup.getParent())
			rootGroup = parentGroup;

		return rootGroup;
	}


	public static List<ThreadGroup> listThreadGroups(final ThreadGroup group, final boolean recursive, final Predicate<ThreadGroup> filter)
	{
		int count = group.activeGroupCount();
		ThreadGroup[] threadGroups;
		do {
			threadGroups = new ThreadGroup[count + (count/2) + 1];
			count = group.enumerate(threadGroups, recursive);

		} while(count >= threadGroups.length);

		final List<ThreadGroup> allGroups = new ArrayList<>(count);
		for(int i = 0; i < count; i++)
			if(filter == null || filter.test(threadGroups[i]))
				allGroups.add(threadGroups[i]);

		return allGroups;
	}

	public static List<ThreadGroup> listThreadGroups(final ThreadGroup group, final boolean recursive)
	{
		return listThreadGroups(group, recursive, null);
	}

	public static List<ThreadGroup> listThreadGroups(final ThreadGroup group)
	{
		return listThreadGroups(group, true);
	}

	public static List<ThreadGroup> listThreadGroups()
	{
		return listThreadGroups(getRootGroup());
	}

	public static ThreadGroup findThreadGroup(final ThreadGroup group, final String groupName)
	{
		final List<ThreadGroup> threadGroups = listThreadGroups(group);

		for(final ThreadGroup threadGroup : threadGroups)
			if(Strings.equals(groupName, threadGroup.getName()))
				return threadGroup;

		return null;
	}

	public static ThreadGroup findThreadGroup(final String groupName)
	{
		return findThreadGroup(getRootGroup(), groupName);
	}


	public static List<Thread> listThreads(final ThreadGroup group, final boolean recursive, final Predicate<Thread> filter)
	{
		int count = group.activeCount();
		Thread[] threads;
		do {
			threads = new Thread[count + (count/2) + 1];
			count = group.enumerate(threads, recursive);

		} while(count >= threads.length);

		final List<Thread> allThreads = new ArrayList<>(count);
		for(int i = 0; i < count; i++)
			if(filter == null || filter.test(threads[i]))
				allThreads.add(threads[i]);

		return allThreads;
	}

	public static List<Thread> listThreads(final ThreadGroup group, final boolean recursive)
	{
		return listThreads(group, recursive, null);
	}

	public static List<Thread> listThreads(final ThreadGroup group)
	{
		return listThreads(group, true);
	}

	public static List<Thread> listThreads()
	{
		return listThreads(getRootGroup());
	}

	public static Thread findThread(final ThreadGroup group, final String threadName)
	{
		final List<Thread> threads = listThreads(group);

		for(final Thread thread : threads)
			if(Strings.equals(threadName, thread.getName()))
				return thread;

		return null;
	}

	public static Thread findThread(final String threadName)
	{
		return findThread(getRootGroup(), threadName);
	}

	public static Thread findThread(final ThreadGroup group, final long threadID)
	{
		final List<Thread> threads = listThreads(group);

		for(final Thread thread : threads)
			if(threadID == thread.getId())
				return thread;

		return null;
	}

	public static Thread findThread(final long threadID)
	{
		return findThread(getRootGroup(), threadID);
	}
}
