export default function QuickRevision() {
  const cards = [
    { pattern: 'Singleton', when: 'One instance needed', how: 'Private constructor + static getInstance()' },
    { pattern: 'Factory', when: 'Create objects without specifying class', how: 'Factory method returns interface' },
    { pattern: 'Builder', when: 'Complex object with many parameters', how: 'Fluent API with method chaining' },
    { pattern: 'Strategy', when: 'Multiple algorithms for same task', how: 'Interface + concrete strategies + context' },
    { pattern: 'Observer', when: 'One-to-many notifications', how: 'Subject maintains list of observers' },
    { pattern: 'Decorator', when: 'Add functionality dynamically', how: 'Wrap objects with decorator classes' },
  ];

  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-gray-900">Quick Revision</h1>
      <div className="grid grid-cols-2 gap-4">
        {cards.map((c, i) => (
          <div key={i} className="bg-white rounded-lg shadow p-6">
            <h3 className="text-xl font-bold text-blue-600 mb-2">{c.pattern}</h3>
            <p className="text-sm text-gray-600 mb-1"><strong>When:</strong> {c.when}</p>
            <p className="text-sm text-gray-600"><strong>How:</strong> {c.how}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
