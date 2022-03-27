package com.durellinux.showcase.commons.graphdb.decoder;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.value.BooleanValue;
import org.neo4j.driver.internal.value.StringValue;
import org.neo4j.driver.types.Node;

import java.util.HashMap;
import java.util.Set;

public class NodeDecoderTest {
    @Test
    public void decodeNode() {
        TestGraphNode expectedObject = new TestGraphNode("mystiring");

        // Given a node
        Node node = new InternalNode(
                10L, Set.of("label"),
                new HashMap<>() {{
                    put("uuid", new StringValue(expectedObject.getUuid().toString()));
                    put("deleted", BooleanValue.fromBoolean(expectedObject.isDeleted()));
                    put("value", new StringValue(expectedObject.getValue()));
                }}
        );

        // When decoding the node
        NodeDecoder nodeDecoder = new NodeDecoder();
        TestGraphNode decodedObject = nodeDecoder.fromNode(node, TestGraphNode.class);

        // Then the node is decoded
        Assertions.assertThat(decodedObject)
                .isEqualToIgnoringGivenFields(expectedObject, "id");
        Assertions.assertThat(decodedObject.getId()).isEqualTo(10L);

    }
}