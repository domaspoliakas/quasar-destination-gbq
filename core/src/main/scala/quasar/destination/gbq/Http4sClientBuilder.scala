/*
 * Copyright 2020 Precog Data
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

package quasar.destination.gbq

import slamdata.Predef.SuppressWarnings

import cats.effect.{ConcurrentEffect, Resource}

import org.http4s.client.Client

import scala.Array
import scala.concurrent.ExecutionContext

// TODO: Remove the implicit EC if/when BlazeClientBuilder switches to ContextShift
trait Http4sClientBuilder {
  @SuppressWarnings(Array("org.wartremover.warts.ImplicitParameter"))
  def apply[F[_]: ConcurrentEffect](implicit ec: ExecutionContext): Resource[F, Client[F]]
}