// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review_semantic_naming

import com.apollographql.apollo.api.InputFieldMarshaller
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMapper
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.example.mutation_create_review_semantic_naming.type.Episode
import com.example.mutation_create_review_semantic_naming.type.ReviewInput
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "LocalVariableName", "RemoveExplicitTypeArguments",
        "NestedLambdaShadowedImplicitParameter")
data class CreateReviewForEpisodeMutation(val ep: Episode, val review: ReviewInput) :
        Mutation<CreateReviewForEpisodeMutation.Data, CreateReviewForEpisodeMutation.Data,
        Operation.Variables> {
    @Transient
    private val variables: Operation.Variables = object : Operation.Variables() {
        override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
            this["ep"] = ep
            this["review"] = review
        }

        override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller { writer ->
            writer.writeString("ep", ep.rawValue)
            writer.writeObject("review", review.marshaller())
        }
    }

    override fun operationId(): String = OPERATION_ID
    override fun queryDocument(): String = QUERY_DOCUMENT
    override fun wrapData(data: Data?): Data? = data
    override fun variables(): Operation.Variables = variables
    override fun name(): OperationName = OPERATION_NAME
    override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper {
        Data(it)
    }

    data class CreateReview(
        val __typename: String,
        /**
         * The number of stars this review gave, 1-5
         */
        val stars: Int,
        /**
         * Comment about the movie
         */
        val commentary: String?
    ) {
        fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeString(RESPONSE_FIELDS[0], __typename)
            it.writeInt(RESPONSE_FIELDS[1], stars)
            it.writeString(RESPONSE_FIELDS[2], commentary)
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forString("__typename", "__typename", null, false, null),
                    ResponseField.forInt("stars", "stars", null, false, null),
                    ResponseField.forString("commentary", "commentary", null, true, null)
                    )

            operator fun invoke(reader: ResponseReader): CreateReview {
                val __typename = reader.readString(RESPONSE_FIELDS[0])
                val stars = reader.readInt(RESPONSE_FIELDS[1])
                val commentary = reader.readString(RESPONSE_FIELDS[2])
                return CreateReview(
                    __typename = __typename,
                    stars = stars,
                    commentary = commentary
                )
            }
        }
    }

    data class Data(val createReview: CreateReview?) : Operation.Data {
        override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
            it.writeObject(RESPONSE_FIELDS[0], createReview?.marshaller())
        }

        companion object {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                    ResponseField.forObject("createReview", "createReview", mapOf<String, Any>(
                        "episode" to mapOf<String, Any>(
                            "kind" to "Variable",
                            "variableName" to "ep"),
                        "review" to mapOf<String, Any>(
                            "kind" to "Variable",
                            "variableName" to "review")), true, null)
                    )

            operator fun invoke(reader: ResponseReader): Data {
                val createReview = reader.readObject<CreateReview>(RESPONSE_FIELDS[0]) { reader ->
                    CreateReview(reader)
                }

                return Data(
                    createReview = createReview
                )
            }
        }
    }

    companion object {
        const val OPERATION_ID: String =
                "dc312e4edc4258722c5ddb00ad2a85faacd285090336d719a22f65fdc94022c7"

        val QUERY_DOCUMENT: String = """
                |mutation CreateReviewForEpisode(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
                |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
                |    __typename
                |    stars
                |    commentary
                |  }
                |}
                """.trimMargin()

        val OPERATION_NAME: OperationName = OperationName { "CreateReviewForEpisode" }
    }
}
