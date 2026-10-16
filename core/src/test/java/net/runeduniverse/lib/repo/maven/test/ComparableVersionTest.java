/*
 * Copyright © 2026 VenaNocta (venanocta@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.runeduniverse.lib.repo.maven.test;

import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import net.runeduniverse.lib.repo.maven.data.ComparableVersion;

public class ComparableVersionTest {

	protected ComparableVersion compoundVersionA = new ComparableVersion("2.0.1-1-999999-SNAPSHOT");
	protected ComparableVersion compoundVersionB = new ComparableVersion("2.1.1-1-999999-SNAPSHOT");
	protected ComparableVersion compoundVersionC = new ComparableVersion("2.0.1-2-999999-SNAPSHOT");
	protected ComparableVersion compoundVersionD = new ComparableVersion("2.2.1-1-999999-SNAPSHOT");

	@Test
	@Tag("smoke")
	public void compareCompoundVersions() {
		LinkedList<ComparableVersion> list = new LinkedList<>();
		list.add(compoundVersionA);
		list.add(compoundVersionB);
		list.add(compoundVersionC);
		list.add(compoundVersionD);

		LinkedList<ComparableVersion> list2 = new LinkedList<>(list);
		Comparator<ComparableVersion> comp = Comparator.naturalOrder();
		list2.sort(comp);

		System.out.println("-- compareCompoundVersions");
		System.out.println("List 1");
		list.stream()
				.forEachOrdered(v -> System.out.println(v.toString()));
		System.out.println("List 2");
		list2.stream()
				.forEachOrdered(v -> System.out.println(v.toString()));

		Assertions.assertEquals(compoundVersionA, list2.get(0));
		Assertions.assertEquals(compoundVersionC, list2.get(1));
		Assertions.assertEquals(compoundVersionB, list2.get(2));
		Assertions.assertEquals(compoundVersionD, list2.get(3));
	}

	@Test
	@Tag("smoke")
	public void compareCompoundVersionsReverse() {
		LinkedList<ComparableVersion> list = new LinkedList<>();
		list.add(compoundVersionA);
		list.add(compoundVersionB);
		list.add(compoundVersionC);
		list.add(compoundVersionD);

		LinkedList<ComparableVersion> list2 = new LinkedList<>(list);
		Comparator<ComparableVersion> comp = Comparator.naturalOrder();
		comp = comp.reversed();
		list2.sort(comp);

		System.out.println("-- compareCompoundVersionsReverse");
		System.out.println("List 1");
		list.stream()
				.forEachOrdered(v -> System.out.println(v.toString()));
		System.out.println("List 2");
		list2.stream()
				.forEachOrdered(v -> System.out.println(v.toString()));

		Assertions.assertEquals(compoundVersionD, list2.get(0));
		Assertions.assertEquals(compoundVersionB, list2.get(1));
		Assertions.assertEquals(compoundVersionC, list2.get(2));
		Assertions.assertEquals(compoundVersionA, list2.get(3));
	}
}
