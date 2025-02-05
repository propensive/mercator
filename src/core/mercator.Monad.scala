/*
    Mercator, version [unreleased]. Copyright 2025 Jon Pretty, Propensive OÜ.

    The primary distribution site is: https://propensive.com/

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software distributed under the
    License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
    either express or implied. See the License for the specific language governing permissions
    and limitations under the License.
*/

package mercator

object Monad:
  inline given [MonadType[_]]: Monad[MonadType] = ${Mercator.monad[MonadType]}

trait Monad[MonadType[_]] extends Functor[MonadType]:
  def bind[ValueType, ValueType2](value: MonadType[ValueType])
     (lambda: ValueType => MonadType[ValueType2])
  :     MonadType[ValueType2]

  extension [ValueType](value: MonadType[ValueType])
    def flatMap[ValueType2](lambda: ValueType => MonadType[ValueType2])
    :     MonadType[ValueType2] =
      bind(value)(lambda)
