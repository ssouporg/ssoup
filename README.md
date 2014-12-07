ssoup
=====

Semantic Services Oriented User Platform

The goal of the SSOUP platform is to promote sharing and reuse of services and data.
The target users of the SSOUP platform are both end users and developers.

High level system decomposition:
- [ssoupl] a functional dynamic language with RDF data types and serializable to RDF (see [ssoupl design page] (https://github.com/ssouporg/ssoup/issues/1) for details)
- [ssoupl-runtime] a runtime for ssoupl described as much as possible in ssoupl itself, and
  for the remaining part via a bridge to the target language/runtime
- [ssoup-registry] a persistent registry of ssoup services and data
	- support most used triple stores
- [ssoup-engine] a ssoup engine has the following responsibilities:
	- maintain a tbox and an abox description of the domain data
	- maintain a set of connections to other engines and registries
	- exposes services to connected engines:
		- automatically expose services for CRUD operations based on tbox entities
		- exposes services from connected registries
		- exposes services from connected engines
	- execute services
	- optionally sopport inference

SSOUP in CLJ/CLJS:
- [ssoupl-cljx] define and implement a bridge layer (as thin as possible) mapping ssoupl
  to Clojure and ClojureScript (to [cljx](https://github.com/lynaghk/cljx)?).
- [ssoupl-cljx-typed] support of core.typed ()

- Already implemented in CLJ Plaza

- Already implemented in [Grafter](http://grafter.org/)

SSOUP was heavily inspired by:

- [FABL](https://s3.amazonaws.com/s3.fabl.net/index.html) by Chris Goat

- [CLJ Plaza](http://antoniogarrote.github.io/clj-plaza/) by Antonio Garrote
