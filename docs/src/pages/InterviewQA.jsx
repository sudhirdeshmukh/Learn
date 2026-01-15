export default function InterviewQA() {
  const questions = [
    { q: 'What is Spring Boot?', a: 'Framework for building production-ready Spring applications with minimal configuration.' },
    { q: 'Explain Dependency Injection', a: 'Design pattern where objects receive dependencies from external source rather than creating them.' },
    { q: 'What is @Autowired?', a: 'Annotation for automatic dependency injection in Spring.' },
    { q: 'Singleton vs Prototype scope?', a: 'Singleton: one instance per container. Prototype: new instance per request.' },
    { q: 'What is AOP?', a: 'Aspect-Oriented Programming: separates cross-cutting concerns like logging, security from business logic.' },
  ];

  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-gray-900">Interview Q&A</h1>
      {questions.map((q, i) => (
        <div key={i} className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-blue-600 mb-2">Q: {q.q}</h3>
          <p className="text-gray-700"><strong>A:</strong> {q.a}</p>
        </div>
      ))}
    </div>
  );
}
